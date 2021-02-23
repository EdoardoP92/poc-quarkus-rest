package poc.quarkus.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import poc.quarkus.rest.resteasyjackson.JacksonResource.Quark;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
    	Quark entity = new Quark("code","description");
    	GenericEntity<Quark> responsePayload = new GenericEntity<>(entity, Quark.class);
    	Response response = Response
    			.status(200)
    			.header("header-key", "header-value")
    			.entity(responsePayload).build();
        return response;
    }
}