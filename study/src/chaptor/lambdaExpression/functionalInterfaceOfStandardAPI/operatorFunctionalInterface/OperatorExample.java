package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.operatorFunctionalInterface;

import chaptor.BasicExample;

import java.util.function.IntBinaryOperator;

public class OperatorExample extends BasicExample {

    private int[] scores = {92, 95, 87};

    public int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for(int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    @Override
    public void run() {
        int max = maxOrMin(
                (a,b) -> {
                    if(a>=b) return a;
                    else return b;
                }
        );
        System.out.println("최대값: " + max);

        int min = maxOrMin(
                (a,b) -> {
                    if(a<=b) return a;
                    else return b;
                }
        );
        System.out.println("최소값: " + min);
    }
}
