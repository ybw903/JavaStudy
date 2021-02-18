import ControllThreadState.InterruptMethod.InterruptExample;
import ControllThreadState.InterruptMethod.StopFlagExample;
import ControllThreadState.JoinMethod.JoinExample;
import ControllThreadState.SleepMethod.SleepExample;
import ControllThreadState.WaitNotifyMethod.WaitNotifyExample;
import ControllThreadState.YieldMethod.YieldExample;
import SynchronizeMethodAndBlock.MainThreadExample;
import ThreadName.ThreadNameExample;
import ThreadPriority.PriorityExample;
import ThreadState.ThreadStateExample;

public class Main {

    public static void main(String[] args) {
        //BeepPrintExample.BeepPrintExample1 beepPrintExample1 = new BeepPrintExample.BeepPrintExample1();
        //beepPrintExample1.beepPrint();

        //BeepPrintExample.BeepPrintExample2 beepPrintExample2 = new BeepPrintExample.BeepPrintExample2();
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

        InterruptExample interruptExample = new InterruptExample();
        interruptExample.interruptExampleRun();
    }
}
