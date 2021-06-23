package faults;

public class NullParamFault {
    private static final String DEFAULT_MESSAGE = "Param should not be null.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static NullParamFault defaultInstance() {
        NullParamFault fault = new NullParamFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
