package chaptor.exception.userDefinitionException;

public class Account {
    private long balacne;

    public Account() {
    }

    public long getBalacne() {
        return balacne;
    }

    public void deposit(int money) {
        balacne += money;
    }

    public void withdraw(int money) throws BalanceInsufficientException {
        if(balacne < money) {
            throw new BalanceInsufficientException("잔고부족: " + (money-balacne) + " 모자람");
        }
        balacne -= money;
    }
}
