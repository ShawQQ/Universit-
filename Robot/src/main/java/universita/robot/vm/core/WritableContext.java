package universita.robot.vm.core;

import universita.robot.vm.core.exception.WritableContextException;

public interface WritableContext<O> extends Context{
    <V> V read(O operand, Class<V> type) throws WritableContextException;
    <V> void write(O operand, V value) throws WritableContextException;
}
