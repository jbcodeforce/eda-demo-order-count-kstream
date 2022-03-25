package ibm.eda.demo.ordermgr.domain;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import ibm.eda.demo.ordermgr.infra.events.OrderEvent;
import ibm.eda.demo.ordermgr.infra.events.OrderEventSerdes;
import ibm.eda.demo.ordermgr.infra.remoteservice.ValidateZipCode;

@Singleton
public class OrderAggregator {
    private static final Logger LOG = Logger.getLogger(OrderAggregator.class.getName()); 
    // store to keep stock per item-id
    public static String ORDER_METRIC_KAFKA_STORE_NAME = "OrderMetricsStore";
     // Input stream is item transaction from the store machines
    @ConfigProperty(name="app.order.topic", defaultValue = "orders")
    public String orderInputStreamName;
    @ConfigProperty(name="app.order.count.topic", defaultValue = "order.metrics")
    public String orderOutputStreamName;
    @Inject
    @RestClient
    ValidateZipCode validateZipCode;


     /**
     * The topology processes the items stream to compute the sum of items sold per item-id, 
     * cross stores
     **/  
    @Produces
    public Topology buildProcessFlow(){
        final StreamsBuilder builder = new StreamsBuilder();
       // AvroSerde<CloudEvent> serde = new io.apicurio.registry.serde.avro.AvroSerde<CloudEvent>();
        //serde.deserializer().setHeaderHandler();
        KStream<String,OrderEvent> orders = builder
        .stream(orderInputStreamName, 
                Consumed.with(Serdes.String(), OrderEventSerdes.OrderEventSerde())); 
        orders.peek( (k,v) -> LOG.info(v.toString()));

        KTable<String,OrderMetric> orderMetrics = orders
		// the key is the customerId but change to the order state name
		.map((k,orderevent) -> {
            LOG.info("Search for:" + orderevent.getShippingAddress().getZipcode());
            LOG.info(validateZipCode.getByZipCode(orderevent.getShippingAddress().getZipcode()).toString());
			OrderMetric newRecord = new OrderMetric();
			newRecord.orderState = orderevent.getStatus();
			return  new KeyValue<String,OrderMetric>(newRecord.orderState,newRecord);
		})
		.groupByKey( Grouped.with(Serdes.String(),OrderEventSerdes.OrderMetricSerde())).
		aggregate( () -> new OrderMetric(),
			       (orderState,newValue,currentValue) -> currentValue.updateCount(1),
			        materializeAsOrderMetricAsKafkaStore());
        produceOrderMetricToOutputStream(orderMetrics);
        return builder.build();
    }


    private static Materialized<String, OrderMetric, KeyValueStore<Bytes, byte[]>> materializeAsOrderMetricAsKafkaStore() { 
        return Materialized.<String, OrderMetric, KeyValueStore<Bytes, byte[]>>as(ORDER_METRIC_KAFKA_STORE_NAME)
                .withKeySerde(Serdes.String()).withValueSerde(OrderEventSerdes.OrderMetricSerde());
    }

    private void produceOrderMetricToOutputStream(KTable<String, OrderMetric> orderMetrics) {
        KStream<String, OrderMetric> metrics = orderMetrics.toStream();
        metrics.print(Printed.toSysOut());
        metrics.to(orderOutputStreamName, Produced.with(Serdes.String(), OrderEventSerdes.OrderMetricSerde()));
    }
}
