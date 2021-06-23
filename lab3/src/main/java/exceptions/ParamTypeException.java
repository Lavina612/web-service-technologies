package exceptions;

import faults.ParamTypeFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ParamTypeFault")
public class ParamTypeException extends Exception {
    private final ParamTypeFault fault;

    public ParamTypeException(String message, ParamTypeFault fault) {
        super(message);
        this.fault = fault;
    }
    public ParamTypeException(String message, ParamTypeFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public ParamTypeFault getFaultInfo() {
        return fault;
    }
}
