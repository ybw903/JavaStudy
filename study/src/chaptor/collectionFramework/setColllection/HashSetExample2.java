package chaptor.collectionFramework.setColllection;

import chaptor.BasicExample;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 extends BasicExample {
    @Override
    public void run() {
        Set<Member> set = new HashSet<Member>();

        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        System.out.println("총 객체수 : " + set.size());
    }
}
