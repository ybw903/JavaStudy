package chaptor.thread.ControllThreadState.InterruptMethod;

import chaptor.BasicTest;

public class InterruptExample extends BasicTest {
    @Override
    public void run() {
        Thread thread = new PrintThread2();
        thread.start();

        try{Thread.sleep(1000);} catch (InterruptedException e){}

        thread.interrupt();
    }

}
