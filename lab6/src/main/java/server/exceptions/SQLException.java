package server.exceptions;

public class SQLException extends Exception {
    public static SQLException DEFAULT_INSTANCE = new SQLException("SQL error. Something went wrong when trying to add a new person.");

    public SQLException(String message) {
        super(message);
    }
}
