package ut;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import ibm.eda.demo.ordermgr.infra.events.Address;
import ibm.eda.demo.ordermgr.infra.events.OrderEvent;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;

public class TestCloudEventProcessing {
    
    @Test
    public void createCloudEvent() throws IllegalStateException, IOException {
        CloudEventBuilder ceb = CloudEventBuilder.v1().withSource(URI.create("https://github.com/jbcodeforce/eda-demo-order-count-kstream/"))
        .withType("OrderEvent");
        Address address = Address.newBuilder()
            .setStreet("mission street")
            .setCity("San Francisco")
            .setState("CA")
            .setCountry("USA")
            .setZipcode("94000")
            .build();
        OrderEvent oe = OrderEvent.newBuilder()
        .setOrderID("O01")
        .setCustomerID("C01")
        .setProductID("P01")
        .setQuantity(10)
        .setStatus("Pending")
        .setCreationDate("2022-03-10")
        .setUpdateDate("2022-03-15")
        .setEventType("OrderCreated")
        .setShippingAddress(address)
        .build();
        System.out.println(oe.toString());
        String id = UUID.randomUUID().toString();
        ByteBuffer bb = OrderEvent.getEncoder().encode(oe);
        System.out.println(bb.toString());
        byte[] data = new byte[bb.remaining()];
        bb.get(data, 0, data.length);
        CloudEvent ce = ceb.newBuilder().withId(id).withData("application/avro",  data).build();
        System.out.println(ce.toString());
    }
}
