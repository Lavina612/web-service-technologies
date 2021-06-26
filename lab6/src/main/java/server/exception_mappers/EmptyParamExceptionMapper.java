package server.exception_mappers;

import server.exceptions.EmptyParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmptyParamExceptionMapper implements ExceptionMapper<EmptyParamException> {
    @Override
    public Response toResponse(EmptyParamException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
