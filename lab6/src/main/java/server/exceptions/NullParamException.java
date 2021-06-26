package server.exceptions;

public class NullParamException extends Exception {
    public static NullParamException DEFAULT_INSTANCE = new NullParamException("Param should not be null.");

    public NullParamException(String message) {
        super(message);
    }
}
