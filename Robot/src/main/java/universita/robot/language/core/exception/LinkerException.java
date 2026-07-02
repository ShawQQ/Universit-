package universita.robot.language.core.exception;

public class LinkerException extends LanguageException {
    public LinkerException(String message) {
        super(message);
    }
    public LinkerException(String message, int line) {
        super(message, line);
    }
}
