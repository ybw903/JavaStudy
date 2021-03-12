import chaptor.BasicExample;
import chaptor.collectionFramework.mapCollection.HashMapExample;
import chaptor.collectionFramework.mapCollection.HashMapExample2;
import chaptor.collectionFramework.mapCollection.HashtableExample;
import chaptor.collectionFramework.mapCollection.PropertiesExample;
import chaptor.collectionFramework.setColllection.HashSetExample1;
import chaptor.collectionFramework.setColllection.HashSetExample2;

public class Main {

    public static void main(String[] args) {

        BasicExample basicExample = new PropertiesExample();
        try {
            basicExample.runWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
