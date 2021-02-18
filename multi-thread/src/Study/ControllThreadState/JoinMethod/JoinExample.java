package Study.ControllThreadState.JoinMethod;

import Study.BasicTest;

public class JoinExample extends BasicTest {
    @Override
    public void run() {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1~100 합: " + sumThread.getSum());
    }

}
