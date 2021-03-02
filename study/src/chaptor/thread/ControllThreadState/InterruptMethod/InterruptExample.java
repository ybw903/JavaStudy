package chaptor.thread.ControllThreadState.InterruptMethod;

import chaptor.BasicExample;

public class InterruptExample extends BasicExample {
    @Override
    public void run() {
        Thread thread = new PrintThread2();
        thread.start();

        try{Thread.sleep(1000);} catch (InterruptedException e){}

        thread.interrupt();
    }

}
