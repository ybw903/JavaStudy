package chaptor.lambdaExpression.targetTypeAndFunctionalInterface.parameterAndNoReturn;

import chaptor.BasicExample;

public class MyFunctionalInterfaceExample extends BasicExample {
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
