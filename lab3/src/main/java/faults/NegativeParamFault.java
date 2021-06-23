package faults;

public class NegativeParamFault {
    private static final String DEFAULT_MESSAGE = "Param should be positive.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static NegativeParamFault defaultInstance() {
        NegativeParamFault fault = new NegativeParamFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
