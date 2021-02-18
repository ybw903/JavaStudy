package Study.ControllThreadState.WaitNotifyMethod;

import Study.BasicTest;

public class WaitNotifyExample extends BasicTest{
    public void waitNotifyExampleRun() {
        WorkObject workObject = new WorkObject();

        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }
    public void waitNotifyExampleRun2() {
        DataBox dataBox = new DataBox();

        ProducerThread producerThread = new ProducerThread(dataBox);
        ConsumerThread consumerThread = new ConsumerThread(dataBox);

        producerThread.start();
        consumerThread.start();
    }
}