package universita.robot.game.core;

import universita.robot.vm.core.Context;
import universita.robot.vm.core.Observer;

public class ConcreteRobot implements Observer {
    @Override
    public void notify(Context ctx) {
        System.out.println(ctx);
    }
}
