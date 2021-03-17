package chaptor.stream.kindsOfStream;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionExample extends BasicExample {
    @Override
    public void run() {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        Stream<Student> stream = studentList.stream();
        stream.forEach(s -> System.out.println(s.getName()));
    }
}
