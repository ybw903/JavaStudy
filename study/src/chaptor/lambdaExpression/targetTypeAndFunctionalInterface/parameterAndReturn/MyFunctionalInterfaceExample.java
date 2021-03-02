package chaptor.lambdaExpression.targetTypeAndFunctionalInterface.parameterAndReturn;

import chaptor.BasicExample;

public class MyFunctionalInterfaceExample extends BasicExample {
    @Override
    public void run() {
        MyFunctionalInterface fi;

        fi = (x,y) -> {
            int result = x + y;
            return result;
        };
        System.out.println(fi.method(2,5));

        fi = (x,y) -> {
            return x+y;
        };
        System.out.println(fi.method(2,5));

        fi = (x,y) -> x + y;
        System.out.println(fi.method(2,5));

        fi = (x,y) -> sum(x,y);
        System.out.println(fi.method(2,5));
    }

    public int sum (int x, int y) {
        return (x+y);
    }
}
