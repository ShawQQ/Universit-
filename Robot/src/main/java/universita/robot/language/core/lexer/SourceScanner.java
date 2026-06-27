package universita.robot.language.core.lexer;

public interface SourceScanner<S> {
    S getSource();
    char peek();
    void advance();
    boolean canConsume();
    int getLine();
    void incrementLine();
}
