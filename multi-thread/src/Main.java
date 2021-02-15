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

        ThreadStateExample threadStateExample = new ThreadStateExample();
        threadStateExample.threadStatePrint();
    }
}
