package chaptor.thread.SynchronizeMethodAndBlock;

import chaptor.BasicExample;

public class MainThreadExample extends BasicExample {
    @Override
    public void run() {
        Calculator calculator = new Calculator();
        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }

}
