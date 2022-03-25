package ut;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import ibm.eda.demo.ordermgr.infra.remoteservice.ValidateZipCode;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestZipCode {
    
    @Inject
    @RestClient
    ValidateZipCode validateZipCode;
    
    @Test
    public void testCallRemote(){
        System.out.println(validateZipCode.getByZipCode("95051").toString());
    }
}
