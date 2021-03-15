package chaptor.collectionFramework.treeCollection;

import chaptor.BasicExample;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample extends BasicExample {
    @Override
    public void run() {
        TreeSet<Person> treeSet = new TreeSet<Person>();

        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("김자바", 25));
        treeSet.add(new Person("박지원", 31));

        Iterator<Person> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person.name + ":" +person.age);
        }
    }
}
