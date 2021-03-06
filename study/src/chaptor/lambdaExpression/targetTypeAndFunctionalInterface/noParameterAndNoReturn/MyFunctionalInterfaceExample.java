package chaptor.lambdaExpression.targetTypeAndFunctionalInterface.noParameterAndNoReturn;

import chaptor.BasicExample;

public class MyFunctionalInterfaceExample extends BasicExample {
    @Override
    public void run() {
        MyFunctionalInterface fi;

        fi = () -> {
            String str = "method call1";
            System.out.println(str);
        };
        fi.method();

        fi = () -> {
            String str = "method call2";
            System.out.println(str);
        };
        fi.method();

        fi = () -> {
            String str = "method call3";
            System.out.println(str);
        };
        fi.method();
    }
}
