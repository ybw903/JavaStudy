import chaptor.BasicExample;
import chaptor.stream.basicStream.iteratorStream.IteratorVsStreamExample;
import chaptor.stream.basicStream.lambdaExpressionStream.LambdaExpressionExample;
import chaptor.stream.basicStream.mapAndReduceStream.MapAndReduceExample;
import chaptor.stream.basicStream.parallelStream.ParallelExample;

public class Main {

    public static void main(String[] args) {

        BasicExample basicExample = new MapAndReduceExample();
//        try {
//            basicExample.runWithException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        basicExample.run();

    }
}
