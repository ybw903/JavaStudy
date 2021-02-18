package Study.ThreadState;

import Study.BasicTest;

public class ThreadStateExample extends BasicTest {

    @Override
    public void run() {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
