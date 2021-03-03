package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.andorAndnegateAndisEqualMethod;

import chaptor.BasicExample;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample extends BasicExample {
    @Override
    public void run() {
        IntPredicate predicateA = a -> a%2 == 0;

        IntPredicate predicateB = (a) -> a%3 == 0;

        IntPredicate predicateAB;
        boolean result;

        //and()
        predicateAB = predicateA.and(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2와 3의 배수입니까? " + result);

        //or()
        predicateAB = predicateA.or(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2 또는 3의 배수입니까? " + result);

        //and()
        predicateAB = predicateA.negate();
        result = predicateAB.test(9);
        System.out.println("9는 홀수입니까? " + result);

    }
}
