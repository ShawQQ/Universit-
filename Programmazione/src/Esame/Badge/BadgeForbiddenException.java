package Esame.Badge;

public class BadgeForbiddenException extends Exception {
	public BadgeForbiddenException(){
		super();
	}
	public BadgeForbiddenException(String message){
		super(message);
	}
}
