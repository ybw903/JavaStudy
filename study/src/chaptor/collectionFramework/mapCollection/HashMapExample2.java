package chaptor.collectionFramework.mapCollection;

import chaptor.BasicExample;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 extends BasicExample {
    @Override
    public void run() {
        Map<Student, Integer> map = new HashMap<Student, Integer>();

        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);

        System.out.println("총 Entry 수: " + map.size());
    }
}
