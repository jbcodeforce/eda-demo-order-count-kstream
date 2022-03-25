package ibm.eda.demo.ordermgr.infra.events;

import org.apache.kafka.common.serialization.Serde;

import ibm.eda.demo.ordermgr.domain.OrderMetric;

public class OrderEventSerdes {
    public static Serde<OrderEvent> OrderEventSerde() {
        return new JSONSerde<OrderEvent>(OrderEvent.class.getCanonicalName());
    }

    public static Serde<OrderMetric> OrderMetricSerde() {
        return new JSONSerde<OrderMetric>(OrderMetric.class.getCanonicalName());
    }
}
