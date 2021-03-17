package chaptor.stream.kindsOfStream;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample extends BasicExample {
    @Override
    public void run() {
        String[] strArray = {"홍길동", "신용권", "김미나"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(s-> System.out.println(s + ","));
        System.out.println();

        int [] intArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(a -> System.out.println(a+ ","));
        System.out.println();
    }
}
