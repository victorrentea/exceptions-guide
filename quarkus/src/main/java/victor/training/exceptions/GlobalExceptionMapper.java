package victor.training.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception ex) {
    return Response.status(400)
        .entity("Mapper A: " + ex.getMessage())
        .build();
  }
}