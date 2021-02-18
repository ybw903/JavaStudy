package ControllThreadState.InterruptMethod;

public class StopFlagExample {
    public void stopFlagExampleRun() {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try { Thread.sleep(1000);}catch (InterruptedException e){}

        printThread.setStop(true);
    }
}
