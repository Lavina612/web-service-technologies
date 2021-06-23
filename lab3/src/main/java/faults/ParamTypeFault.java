package faults;

public class ParamTypeFault {
    private static final String DEFAULT_MESSAGE = "Param should match the corresponding type: string, integer or boolean.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ParamTypeFault defaultInstance() {
        ParamTypeFault fault = new ParamTypeFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
