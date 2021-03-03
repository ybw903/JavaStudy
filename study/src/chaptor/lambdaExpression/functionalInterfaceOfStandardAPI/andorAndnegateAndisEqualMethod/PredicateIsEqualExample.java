package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.andorAndnegateAndisEqualMethod;

import chaptor.BasicExample;

import java.util.function.Predicate;

public class PredicateIsEqualExample extends BasicExample {
    @Override
    public void run() {
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null: " + predicate.test(null));

        predicate = Predicate.isEqual("Java8");
        System.out.println("null, Java8: " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("Java8, null: " + predicate.test("Java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("Java8, Java8: " + predicate.test("Java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("Java7, Java8: " + predicate.test("Java7"));
    }
}
