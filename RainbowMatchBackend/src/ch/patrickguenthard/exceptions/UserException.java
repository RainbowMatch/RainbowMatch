package ch.patrickguenthard.exceptions;

public abstract class UserException extends Exception {
    public UserException(){
	super();
    }
    
    public UserException(String message){
	super(message);
    }
}
