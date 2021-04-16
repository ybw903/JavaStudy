package chaptor.stream.looping;

import chaptor.BasicExample;

import java.util.Arrays;

public class LoopingExample extends BasicExample {
    @Override
    public void run() {
        int[] intArr = {1,2,3,4,5};

        System.out.println("[peek()를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .peek(n-> System.out.println(n));

        System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
        int total = Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .peek(n -> System.out.println(n))
                .sum();
        System.out.println("총합: " + total);

        System.out.println("[forEach()를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
                .filter(a -> a%2 ==0)
                .forEach(n -> System.out.println(n));

    }
}
