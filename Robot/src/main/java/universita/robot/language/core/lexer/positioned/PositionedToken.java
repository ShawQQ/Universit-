package universita.robot.language.core.lexer.positioned;

import universita.robot.language.core.lexer.Token;

import java.util.Objects;

public record PositionedToken<T extends Token>(T token, int line) implements Token {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PositionedToken<?> that = (PositionedToken<?>) o;
        return line() == that.line() && Objects.equals(token(), that.token());
    }

    @Override
    public int hashCode() {
        return Objects.hash(token(), line());
    }
}
