package chaptor.stream.kindsOfStream;

import chaptor.BasicExample;

import java.util.stream.IntStream;

public class FromIntRangeExample extends BasicExample {
    private int sum = 0 ;
    @Override
    public void run() {
        IntStream stream = IntStream.rangeClosed(1,100);
        stream.forEach(a -> sum += a);
        System.out.println("총합: " + sum);
    }
}
