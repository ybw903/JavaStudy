package Study.thread.ControllThreadState.InterruptMethod;

import Study.BasicTest;

public class StopFlagExample extends BasicTest {
    @Override
    public void run() {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try { Thread.sleep(1000);}catch (InterruptedException e){}

        printThread.setStop(true);
    }

}
