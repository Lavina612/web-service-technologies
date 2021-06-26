package exceptions;

import faults.AuthenticationFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "EmptyParamFault")
public class AuthenticationException extends Exception{
    private final AuthenticationFault fault;

    public AuthenticationException(String message, AuthenticationFault fault) {
        super(message);
        this.fault = fault;
    }
    public AuthenticationException(String message, AuthenticationFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public AuthenticationFault getFaultInfo() {
        return fault;
    }
}
