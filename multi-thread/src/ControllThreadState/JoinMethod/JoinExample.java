package ControllThreadState.JoinMethod;

public class JoinExample {
    public void joinExampleRun() {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1~100 합: " + sumThread.getSum());
    }
}
