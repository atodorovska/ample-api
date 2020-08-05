package mk.ukim.finki.ampleapi.domain.exceptions;

public class UsernameExistsException extends Exception{

    public UsernameExistsException(String message) {
        super(message);
    }
    public UsernameExistsException() {}
}
