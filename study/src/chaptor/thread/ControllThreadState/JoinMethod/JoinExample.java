package chaptor.thread.ControllThreadState.JoinMethod;

import chaptor.BasicExample;

public class JoinExample extends BasicExample {
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
