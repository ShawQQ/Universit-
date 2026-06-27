package universita.robot.language.core.exception;

public class LanguageException extends RuntimeException {
    public LanguageException(String message, int line) {
        super(message + " a riga %d".formatted(line));
    }
}
