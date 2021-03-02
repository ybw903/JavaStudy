package chaptor.lambdaExpression.functionalInterfaceOfStandardAPI.functionFunctionalInterface;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 extends BasicExample {

    private List<Student> list = Arrays.asList(
            new Student("홍길동", 90, 96),
            new Student("신용권", 95, 93)
    );

    public void printString(Function<Student, String> function) {
        for(Student student : list) {
            System.out.println(function.apply(student)+ " ");
        }
        System.out.println();
    }

    public void printInt(ToIntFunction<Student> function) {
        for(Student student : list) {
            System.out.println(function.applyAsInt(student)+ " ");
        }
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("[학생 이름]");
        printString( t -> t.getName());

        System.out.println("[영어 점수]");
        printInt( t -> t.getEnglishScore());

        System.out.println("[수학 점수]");
        printInt( t -> t.getMathScore());
    }
}
