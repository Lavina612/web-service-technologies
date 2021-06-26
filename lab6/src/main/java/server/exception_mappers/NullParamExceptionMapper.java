package server.exception_mappers;

import server.exceptions.NullParamException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NullParamExceptionMapper implements ExceptionMapper<NullParamException> {
    @Override
    public Response toResponse(NullParamException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
