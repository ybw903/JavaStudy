package Study.thread.SynchronizeMethodAndBlock;

import Study.BasicTest;

public class MainThreadExample extends BasicTest {
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
