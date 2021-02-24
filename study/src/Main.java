import chaptor.BasicTest;
import chaptor.generic.boundedTypeParameter.BoundedTypeParameterExample;
import chaptor.generic.childProductAndStorageExample.ChildProductAndStorageExample;
import chaptor.generic.method.BoxingMethodExample;
import chaptor.generic.method.CompareMethodExample;
import chaptor.generic.multiTypeParameter.ProductExample;
import chaptor.generic.type.BoxExample;
import chaptor.generic.wildCardType.WildCardExample;
import chaptor.thread.SynchronizeMethodAndBlock.MainThreadExample;

public class Main {

    public static void main(String[] args) {

        BasicTest basicTest = new ChildProductAndStorageExample();
        basicTest.run();

    }
}
