package exceptions;

import faults.NegativeParamFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "NegativeParamFault")
public class NegativeParamException extends Exception {
    private final NegativeParamFault fault;

    public NegativeParamException(String message, NegativeParamFault fault) {
        super(message);
        this.fault = fault;
    }

    public NegativeParamException(String message, NegativeParamFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public NegativeParamFault getFaultInfo() {
        return fault;
    }
}
