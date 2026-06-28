package universita.robot.language.implementation.generic;

import universita.robot.language.core.lexer.SourceScanner;

public interface PositionedSourceScanner<S> extends SourceScanner<S> {
    int getLine();
}
