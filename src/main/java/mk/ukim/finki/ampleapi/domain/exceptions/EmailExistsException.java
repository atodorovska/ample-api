package mk.ukim.finki.ampleapi.domain.exceptions;

public class EmailExistsException extends Exception{

    public EmailExistsException(String message) {
        super(message);
    }
    public EmailExistsException() {}
}
