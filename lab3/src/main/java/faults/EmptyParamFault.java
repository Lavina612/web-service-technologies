package faults;

public class EmptyParamFault {
    private static final String DEFAULT_MESSAGE = "Param should not be empty.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EmptyParamFault defaultInstance() {
        EmptyParamFault fault = new EmptyParamFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
