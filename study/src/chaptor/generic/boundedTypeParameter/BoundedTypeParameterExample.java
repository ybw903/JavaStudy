package chaptor.generic.boundedTypeParameter;

import chaptor.BasicExample;

public class BoundedTypeParameterExample extends BasicExample {
    @Override
    public void run() {
        //String str = Util. compare("a", "b");

        int result1= Util.compare(10,20);
        System.out.println(result1);

        int result2= Util.compare(4.5,3);
        System.out.println(result2);
    }
}
