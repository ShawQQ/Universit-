package universita.robot.language.core.exception;

public class LexerException extends LanguageException{
    public LexerException(String msg, int line){ super(msg, line); }
    public LexerException(String msg){ super(msg); }
}
