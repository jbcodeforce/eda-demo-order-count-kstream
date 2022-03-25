package ibm.eda.demo.ordermgr.infra.remoteservice;

import java.util.Set;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/info.json")
@RegisterRestClient(configKey="ValidateZipCode")
@Singleton
public interface ValidateZipCode {
 
    @GET
    @Path("/{zipcode}")
    CityData getByZipCode(@PathParam String zipcode);
}
