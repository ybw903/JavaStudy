package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.methodReferences;

import chaptor.BasicExample;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample extends BasicExample {
    @Override
    public void run() {
        ToIntBiFunction<String, String> function;

        function = (a,b) -> a.compareToIgnoreCase(b);
        print(function.applyAsInt("Java8", "JAVA8"));

        function = String::compareToIgnoreCase;
        print(function.applyAsInt("Java8", "JAVA8"));
    }

    private void print(int order) {
        if(order<0) System.out.println("사전 순으로 먼저 옵니다");
        else if(order == 0) System.out.println("동일한 문자열입니다.");
        else System.out.println("사전순으로 나중에 옵니다.");
    }
}
