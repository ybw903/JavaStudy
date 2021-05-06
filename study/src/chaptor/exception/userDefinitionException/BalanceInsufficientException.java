package chaptor.exception.userDefinitionException;

public class BalanceInsufficientException extends Exception{
    public BalanceInsufficientException() {
    }

    // catch 블록의 예외 처리 코드에서 이용하기 위함
    public BalanceInsufficientException(String message) {
        super(message);
    }
}
