package exceptions;

import faults.SQLFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "SQLFault")
public class SQLException extends Exception {
    private final SQLFault fault;

    public SQLException(String message, SQLFault fault) {
        super(message);
        this.fault = fault;
    }

    public SQLException(String message, SQLFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public SQLFault getFaultInfo() {
        return fault;
    }
}
