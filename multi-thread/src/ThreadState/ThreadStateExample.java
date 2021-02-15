package ThreadState;

public class ThreadStateExample {
    public void threadStatePrint(){
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
