package faults;

public class SQLFault {
    private static final String DEFAULT_MESSAGE = "SQL error. Something went wrong when trying to add a new person.";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SQLFault defaultInstance() {
        SQLFault fault = new SQLFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
