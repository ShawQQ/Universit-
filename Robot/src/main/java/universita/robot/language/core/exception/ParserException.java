package universita.robot.language.core.exception;

public class ParserException extends LanguageException {
    public ParserException(String message, int line) {
        super(message, line);
    }
    public ParserException(String message) {
        super(message);
    }
}
