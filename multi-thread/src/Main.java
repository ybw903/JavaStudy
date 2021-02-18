import Study.BasicTest;
import Study.ControllThreadState.InterruptMethod.InterruptExample;
import Study.ThreadGroup.ThreadGroupExample;
import Study.ThreadGroup.ThreadinfoExample;

public class Main {

    public static void main(String[] args) {
        //Study.BeepPrintExample.BeepPrintExample1 beepPrintExample1 = new Study.BeepPrintExample.BeepPrintExample1();
        //beepPrintExample1.beepPrint();

        //Study.BeepPrintExample.BeepPrintExample2 beepPrintExample2 = new Study.BeepPrintExample.BeepPrintExample2();
        //beepPrintExample2.beepPrint();

        //BeepPrintExample3 beepPrintExample3 = new BeepPrintExample3();
        //beepPrintExample3.beepPrint();

        //ThreadNameExample threadNameExample = new ThreadNameExample();
        //threadNameExample.threadNamePrint();

        //PriorityExample priorityExample = new PriorityExample();
        //priorityExample.printPriorityThread();

        //MainThreadExample mainThreadExample = new MainThreadExample();
        //mainThreadExample.mainThreadRun();

        //ThreadStateExample threadStateExample = new ThreadStateExample();
        //threadStateExample.threadStatePrint();

        //SleepExample sleepExample = new SleepExample();
        //sleepExample.sleepExampleRun();

        //YieldExample yieldExample = new YieldExample();
        //yieldExample.YieldExampleRun();

        //JoinExample joinExample = new JoinExample();
        //joinExample.joinExampleRun();

        //WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        //waitNotifyExample.waitNotifyExampleRun2();

        //StopFlagExample stopFlagExample = new StopFlagExample();
        //stopFlagExample.stopFlagExampleRun();

        //InterruptExample interruptExample = new InterruptExample();
        //interruptExample.run();

        BasicTest basicTest = new ThreadGroupExample();
        basicTest.run();

    }
}
