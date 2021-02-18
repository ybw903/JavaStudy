package ControllThreadState.InterruptMethod;

public class InterruptExample {
    public void interruptExampleRun() {
        Thread thread = new PrintThread2();
        thread.start();

        try{Thread.sleep(1000);} catch (InterruptedException e){}

        thread.interrupt();
    }
}
