package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.supplierFunctionalInterface;

import chaptor.BasicExample;

import java.util.function.IntSupplier;

public class SupplierExample extends BasicExample {
    @Override
    public void run() {
        IntSupplier intSupplier = () ->{
            int num = (int) (Math.random()*6) +1;
            return num;
        };

        int num = intSupplier.getAsInt();
        System.out.println("눈의 수: " + num);
    }
}
