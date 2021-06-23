package exceptions;

import faults.EmptyParamFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "EmptyParamFault")
public class EmptyParamException extends Exception{
    private final EmptyParamFault fault;

    public EmptyParamException(String message, EmptyParamFault fault) {
        super(message);
        this.fault = fault;
    }
    public EmptyParamException(String message, EmptyParamFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public EmptyParamFault getFaultInfo() {
        return fault;
    }
}
