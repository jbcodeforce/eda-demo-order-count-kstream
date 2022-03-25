package ut;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Properties;

import com.google.inject.Inject;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.TestOutputTopic;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ibm.eda.demo.ordermgr.domain.OrderAggregator;
import ibm.eda.demo.ordermgr.domain.OrderMetric;
import ibm.eda.demo.ordermgr.infra.events.OrderEvent;
import ibm.eda.demo.ordermgr.infra.events.OrderEventSerdes;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestOrderStateAggregate {

    public static String ORDER_METRIC_KAFKA_STORE_NAME = "OrderMetricsStore";
    private static TopologyTestDriver testDriver;

    @ConfigProperty(name= "app.order.topic")
    private static String inTopicName;
    @ConfigProperty(name= "app.order.metric.topic")
    private static String outTopicName;
    @Inject
    OrderAggregator orderAggregator;
    
    private static TestInputTopic<String, OrderEvent> inTopic;
    private static TestOutputTopic<String, OrderMetric> outTopic;

   

    @BeforeEach
    public void buildTopology() {
        Topology topology = orderAggregator.buildProcessFlow();
        testDriver = new TopologyTestDriver(topology, getStreamsConfig());
        inTopic = testDriver.createInputTopic(inTopicName, new StringSerializer(), OrderEventSerdes.OrderEventSerde().serializer());
        outTopic = testDriver.createOutputTopic(outTopicName, new StringDeserializer(), OrderEventSerdes.OrderMetricSerde().deserializer());
    }

    public  static Properties getStreamsConfig() {
        final Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "order-state-aggregator");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummmy:1234");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,  Serdes.String().getClass());
        return props;
    }

    @AfterEach
    public void teardown() {
        try {
            testDriver.close();
        } catch (final Exception e) {
             System.out.println("Ignoring exception, test failing due this exception:" + e.getLocalizedMessage());
        }
     }

    @Test
    public void shouldHaveAnEmptyOutputTopic() {
        assertThat(outTopic.isEmpty(), is(true));
    }
    
    /**
     * Validate 1 order prending generate on metric with (pending,1)
     */
    @Test
    public void shouldGenerateOnePendingMetric(){
        OrderEvent oe = new OrderEvent("O_01", "P01", "customerID", 10, "Pending", "2022-03-23", "2022-03-23", null, "OrderCreatedEvent");
        inTopic.pipeInput(oe.getCustomerID(), oe);
        Assertions.assertEquals(1, outTopic.readKeyValue().value.count);
    }
}
