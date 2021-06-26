package server.exception_mappers;

import server.exceptions.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {
    @Override
    public Response toResponse(SQLException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}