package mk.ukim.finki.ampleapi.domain.exceptions;

public class InvalidPasswordException extends Exception{

    public InvalidPasswordException(String message) {
        super(message);
    }
    public InvalidPasswordException() {}
}
