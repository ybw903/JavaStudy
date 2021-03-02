package chaptor.thread.ControllThreadState.InterruptMethod;

import chaptor.BasicExample;

public class StopFlagExample extends BasicExample {
    @Override
    public void run() {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try { Thread.sleep(1000);}catch (InterruptedException e){}

        printThread.setStop(true);
    }

}
