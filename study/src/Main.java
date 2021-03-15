import chaptor.BasicExample;
import chaptor.collectionFramework.lifoAndfifoCollection.QueueExample;
import chaptor.collectionFramework.lifoAndfifoCollection.StackExample;
import chaptor.collectionFramework.mapCollection.HashMapExample;
import chaptor.collectionFramework.mapCollection.HashMapExample2;
import chaptor.collectionFramework.mapCollection.HashtableExample;
import chaptor.collectionFramework.mapCollection.PropertiesExample;
import chaptor.collectionFramework.setColllection.HashSetExample1;
import chaptor.collectionFramework.setColllection.HashSetExample2;
import chaptor.collectionFramework.treeCollection.*;

public class Main {

    public static void main(String[] args) {

        BasicExample basicExample = new QueueExample();
//        try {
//            basicExample.runWithException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        basicExample.run();

    }
}
