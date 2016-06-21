package ch.patrickguenthard.exceptions;

public class UnsupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnsupportedException(){
		super();
	}
	
	public UnsupportedException(String message){
		super(message);
	}

}
