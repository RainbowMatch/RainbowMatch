package ch.patrickguenthard.rest;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.*;

@Path("api/tutorial")
@Produces({"application/json"})
public class ExampleRest {
	
    @GET
    @Path("helloworld")
    public List<String> helloworld() {
    	List<String> list = new ArrayList<>();
    	list.add("Hello");
    	list.add("World");
        return list;
    }
}
