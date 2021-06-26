package server.exceptions;

public class AuthenticationException extends Exception {
    public static AuthenticationException DEFAULT_INSTANCE = new AuthenticationException("Invalid user or password.");

    public AuthenticationException(String message) {
        super(message);
    }
}
