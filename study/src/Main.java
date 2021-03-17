import chaptor.BasicExample;
import chaptor.stream.basicStream.iteratorStream.IteratorVsStreamExample;
import chaptor.stream.basicStream.lambdaExpressionStream.LambdaExpressionExample;
import chaptor.stream.basicStream.mapAndReduceStream.MapAndReduceExample;
import chaptor.stream.basicStream.parallelStream.ParallelExample;
import chaptor.stream.kindsOfStream.FromArrayExample;
import chaptor.stream.kindsOfStream.FromCollectionExample;
import chaptor.stream.kindsOfStream.FromFileContentExample;
import chaptor.stream.kindsOfStream.FromIntRangeExample;

public class Main {

    public static void main(String[] args) {

        BasicExample basicExample = new FromFileContentExample();
        try {
            basicExample.runWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //basicExample.run();

    }
}
