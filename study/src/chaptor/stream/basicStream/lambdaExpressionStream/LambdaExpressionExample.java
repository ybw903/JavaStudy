package chaptor.stream.basicStream.lambdaExpressionStream;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionExample extends BasicExample {
    @Override
    public void run() {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("신용권", 92)
        );

        Stream<Student> stream = list.stream();
        stream.forEach( s->{
            String name = s.getName();
            int score = s.getScore();
            System.out.println(name + "-" + score);
        });
    }
}
