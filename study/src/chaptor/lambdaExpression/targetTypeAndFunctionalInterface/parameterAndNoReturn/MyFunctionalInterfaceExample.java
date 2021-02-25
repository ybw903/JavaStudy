package chaptor.lambdaExpression.targetTypeAndFunctionalInterface.parameterAndNoReturn;

import chaptor.BasicTest;

public class MyFunctionalInterfaceExample extends BasicTest {
    @Override
    public void run() {
        MyFunctionalInterface fi;

        fi = (x) ->{
            int result = x*5;
            System.out.println(result);
        };
        fi.method(2);

        fi = (x) ->{
            System.out.println(x*5);
        };
        fi.method(2);

        fi = (x) -> System.out.println(x*5);
        fi.method(2);
    }
}
