package server.exceptions;

public class EmptyParamException extends Exception {
    public static EmptyParamException DEFAULT_INSTANCE = new EmptyParamException("Param should not be empty.");

    public EmptyParamException(String message) {
        super(message);
    }
}