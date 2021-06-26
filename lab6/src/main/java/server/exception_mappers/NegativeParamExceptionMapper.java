package server.exception_mappers;

import server.exceptions.NegativeParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NegativeParamExceptionMapper implements ExceptionMapper<NegativeParamException> {
    @Override
    public Response toResponse(NegativeParamException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
