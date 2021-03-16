package chaptor.stream.basicStream.parallelStream;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample extends BasicExample {
    @Override
    public void run() {
        List<String> list = Arrays.asList(
                "홍길동", "신용권", "김자바",
                "람다식", "박병렬"
        );

        //순차 처리
        Stream<String> stream = list.stream();
        stream.forEach(this::print);

        System.out.println();

        //병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(this::print);
    }

    public void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
