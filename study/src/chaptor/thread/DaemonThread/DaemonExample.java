package chaptor.thread.DaemonThread;

import chaptor.AutoSaveThread;
import chaptor.BasicTest;

public class DaemonExample extends BasicTest{
    @Override
    public void run() {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){

        }

        System.out.println("메인 스레드 종료");
    }
}
