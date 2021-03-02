package chaptor.generic.childProductAndStorageExample;

import chaptor.BasicExample;

public class ChildProductAndStorageExample extends BasicExample {
    @Override
    public void run() {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("SmartTV");
        product.setCompany("Samsung");

        Storage<Tv> storage = new StorageImpl<Tv>(100);
        storage.add(new Tv(),0);
        Tv tv = storage.get(0);
    }
}
