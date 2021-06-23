package exceptions;

import faults.NullParamFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "NullParamFault")
public class NullParamException extends Exception {
    private final NullParamFault fault;

    public NullParamException(String message, NullParamFault fault) {
        super(message);
        this.fault = fault;
    }

    public NullParamException(String message, NullParamFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public NullParamFault getFaultInfo() {
        return fault;
    }
}
