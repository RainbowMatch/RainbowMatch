package ch.patrickguenthard.exceptions;


public class IncorrectLoginException extends UserException {
    public IncorrectLoginException() {
	super();
    }

    public IncorrectLoginException(String message) {
	super(message);
    }
}
