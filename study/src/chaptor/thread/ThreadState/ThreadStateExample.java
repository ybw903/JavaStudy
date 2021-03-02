package chaptor.thread.ThreadState;

import chaptor.BasicExample;

public class ThreadStateExample extends BasicExample {

    @Override
    public void run() {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
