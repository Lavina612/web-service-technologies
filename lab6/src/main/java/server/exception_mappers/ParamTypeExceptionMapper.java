package server.exception_mappers;

import server.exceptions.ParamTypeException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ParamTypeExceptionMapper implements ExceptionMapper<ParamTypeException> {
    @Override
    public Response toResponse(ParamTypeException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
