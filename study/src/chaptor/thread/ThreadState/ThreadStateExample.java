package chaptor.thread.ThreadState;

import chaptor.BasicTest;

public class ThreadStateExample extends BasicTest {

    @Override
    public void run() {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
