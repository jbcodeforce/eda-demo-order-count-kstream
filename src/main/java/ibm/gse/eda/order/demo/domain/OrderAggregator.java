package ibm.gse.eda.order.demo.domain;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.cloudevents.CloudEvent;

@Singleton
public class OrderAggregator {
    private static final Logger LOG = Logger.getLogger(OrderAggregator.class.getName()); 
    // store to keep stock per item-id
    public static String ORDER_COUNT_KAFKA_STORE_NAME = "OrderCount";
     // Input stream is item transaction from the store machines
    @ConfigProperty(name="app.order.topic", defaultValue = "orders")
    public String orderInputStreamName;
    @ConfigProperty(name="app.order.count.topic", defaultValue = "order.metrics")
    public String orderOutputStreamName;
    
     /**
     * The topology processes the items stream to compute the sum of items sold per item-id, 
     * cross stores
     **/  
    @Produces
    public Topology buildProcessFlow(){
        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String,CloudEvent> orders = builder.stream(orderInputStreamName, 
        Consumed.with(Serdes.String(),  new io.apicurio.registry.serde.avro.AvroSerde<CloudEvent>())); 
        orders.peek( (k,v) -> System.out.println(v));
        return builder.build();
    }
/*
 // process order and aggregate by order status
        KTable<String,OrderMetric> metrics = orders
            // the key is the store name
            .map((k,order) -> {
                OrderMetric newRecord = new OrderMetric();
                newRecord.updateMetricFromTransaction(order);
               return  new KeyValue<String,OrderMetric>(order.status,newRecord);
            })
            aggregate( () -> new ItemInventory(),
                (itemID,newValue,currentValue) -> currentValue.updateStockQuantity(itemID,newValue.currentStock),
                materializeAsStoreInventoryKafkaStore());
        produceStoreInventoryToOutputStream(itemItemInventory);
*/
}
