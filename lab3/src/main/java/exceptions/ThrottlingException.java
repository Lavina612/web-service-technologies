package exceptions;

import faults.ThrottlingFault;

import javax.ws.rs.WebApplicationException;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "ThrottlingFault")
public class ThrottlingException extends WebApplicationException {
    private final ThrottlingFault fault;

    public ThrottlingException(String message, ThrottlingFault fault) {
        super(message);
        this.fault = fault;
    }

    public ThrottlingException(String message, ThrottlingFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public ThrottlingFault getFaultInfo() {
        return fault;
    }
}
