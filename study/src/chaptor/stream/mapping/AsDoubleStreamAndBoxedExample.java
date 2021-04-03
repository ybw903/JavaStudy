package chaptor.stream.mapping;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample extends BasicExample {
    @Override
    public void run() {
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);

        intStream
                .asDoubleStream()
                .forEach(d-> System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray); // 생략시 stream has already been operated upon or closed 예외 발생
        intStream
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));
    }
}
