package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.methodReferences;

import chaptor.BasicExample;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample extends BasicExample {
    @Override
    public void run() {
        Function<String, Member> function1 = Member::new;
        Member member1 = function1.apply("angel");

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("신천사", "angel");
    }
}
