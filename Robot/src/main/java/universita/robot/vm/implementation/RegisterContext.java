package universita.robot.vm.implementation;

import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.Observer;
import universita.robot.vm.core.WritableContext;
import universita.robot.vm.core.exception.WritableContextException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RegisterContext implements WritableContext<String> {
    private final List<Observer> observerList;
    private final Map<String, InputOutput<Object>> registers;

    public RegisterContext(Map<String, InputOutput<Object>> registers) {
        this.registers = registers;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : this.observerList){
            o.notify(this);
        }
    }

    @Override
    public <V> V read(String operand, Class<V> type) throws WritableContextException {
        if(!this.isValidRegister(operand))
            throw new WritableContextException("Registro %s non disponibile".formatted(operand));
        return type.cast(registers.get(operand).read());
    }

    @Override
    public <V> void write(String operand, V value) throws WritableContextException{
        if(!this.isValidRegister(operand))
            throw new WritableContextException("Registro %s non disponibile".formatted(operand));
        this.registers.get(operand).write(value);
    }

    private boolean isValidRegister(String operand) {
        return this.registers.containsKey(operand);
    }

    @Override
    public String toString() {
        return registers.toString();
    }
}
