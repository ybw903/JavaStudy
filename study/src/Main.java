import chaptor.BasicExample;
import chaptor.stream.basicStream.iteratorStream.IteratorVsStreamExample;
import chaptor.stream.basicStream.lambdaExpressionStream.LambdaExpressionExample;
import chaptor.stream.basicStream.mapAndReduceStream.MapAndReduceExample;
import chaptor.stream.basicStream.parallelStream.ParallelExample;
import chaptor.stream.kindsOfStream.FromArrayExample;
import chaptor.stream.kindsOfStream.FromCollectionExample;
import chaptor.stream.kindsOfStream.FromFileContentExample;
import chaptor.stream.kindsOfStream.FromIntRangeExample;
import chaptor.stream.mapping.AsDoubleStreamAndBoxedExample;
import chaptor.stream.mapping.FlatMapExample;
import chaptor.stream.mapping.MapExample;
import chaptor.stream.pipeLine.StreamPipelinesExample;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BasicExample basicExample = new AsDoubleStreamAndBoxedExample();
        basicExample.run();
        //basicExample.run();

    }
}
