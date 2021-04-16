package chaptor.stream.basicAggregate;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggregateExample extends BasicExample {
    @Override
    public void run() {

        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});

        long count = intStream
                .filter(n -> n%2 ==0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        long sum = intStream
                .filter(n -> n%2 ==0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        double avg = intStream
                .filter(n -> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        int max = intStream
                .filter(n -> n%2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        int min = intStream
                .filter(n -> n%2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});

        int first = intStream
                .filter(n -> n%3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫번째 3의 배수: " + first);
    }
}
