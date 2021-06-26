package server.exceptions;

public class NegativeParamException extends Exception {
    public static NegativeParamException DEFAULT_INSTANCE = new NegativeParamException("Param should be positive.");

    public NegativeParamException(String message) {
        super(message);
    }
}
