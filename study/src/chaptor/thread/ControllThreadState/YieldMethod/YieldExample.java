package chaptor.thread.ControllThreadState.YieldMethod;

import chaptor.BasicExample;

public class YieldExample extends BasicExample {
    @Override
    public void run() {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();

        try{Thread.sleep(3000);} catch (InterruptedException e){}
        threadA.work = false;

        try{Thread.sleep(3000);} catch (InterruptedException e){}
        threadA.work = true;

        try{Thread.sleep(3000);} catch (InterruptedException e){}
        threadA.stop = true;
        threadB.stop = true;
    }

}
