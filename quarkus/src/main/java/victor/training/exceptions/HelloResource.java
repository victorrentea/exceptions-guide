package victor.training.exceptions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    @GET
    public String hello() {
        if (Math.random() > .5) {
            throw new IllegalArgumentException("Useful debug info");
        }
        return "Hello Quarkus! Hi 1-sec restart!";
    }
}


