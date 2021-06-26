package server.exceptions;

public class ParamTypeException extends Exception {
    public static ParamTypeException DEFAULT_INSTANCE = new ParamTypeException("Param should match the corresponding type: string, integer or boolean.");

    public ParamTypeException(String message) {
        super(message);
    }
}
