package Esame.ForzaQuattro;

/**
 * Semplice eccezione custom per l'implementazione corretta della classe partita
 */

public final class ClosedGameException extends RuntimeException {
    public ClosedGameException(String message){
        super(message);
    }
    public ClosedGameException(){}
}
