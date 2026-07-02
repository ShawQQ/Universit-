package universita.robot.language.core.linker;

import universita.robot.language.core.parser.ASTNode;

public interface Linker<N extends ASTNode> {
    N link(N root);
}
