package ibm.eda.demo.ordermgr.domain;

public class OrderMetric {
    public String orderState;
    public long count;

    public OrderMetric(){}

    public OrderMetric(String orderState, long count) {
        this.orderState = orderState;
        this.count = count;
    }

    public OrderMetric updateCount(long n) {
        count = count + n;
        return this;
    }

    public String toString() {
        return orderState + " -> " + count;
    }
}
