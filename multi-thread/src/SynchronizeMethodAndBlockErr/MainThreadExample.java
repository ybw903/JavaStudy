package SynchronizeMethodAndBlockErr;

public class MainThreadExample {

    public void mainThreadRun() {
        Calculator calculator = new Calculator();
        User1 user1 = new User1();
        user1.start();

        User2 user2 = new User2();
        user2.start();
    }
}
