package chaptor.stream.mapping;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.List;

public class MapExample extends BasicExample {
    @Override
    public void run() {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동",10),
                new Student("신용권",20),
                new Student("유미선",30)
        );

        studentList.stream()
                .mapToInt(Student::getScore)
                .forEach(score -> System.out.println(score));
    }
}
