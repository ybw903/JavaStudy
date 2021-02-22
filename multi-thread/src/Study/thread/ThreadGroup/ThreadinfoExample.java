package Study.thread.ThreadGroup;

import Study.AutoSaveThread;
import Study.BasicTest;

import java.util.Map;
import java.util.Set;

public class ThreadinfoExample extends BasicTest{
    @Override
    public void run() {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet();

        for(Thread thread : threads) {
            System.out.println("Name: " + thread.getName()+
                    ((thread.isDaemon())?"데몬":"(주)"));
            System.out.println("\t "+ "소속그룹: " + thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}
