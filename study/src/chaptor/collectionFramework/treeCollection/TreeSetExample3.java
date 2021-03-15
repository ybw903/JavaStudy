package chaptor.collectionFramework.treeCollection;

import chaptor.BasicExample;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 extends BasicExample {
    @Override
    public void run() {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("apple");
        treeSet.add("forever");
        treeSet.add("description");
        treeSet.add("ever");
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guess");
        treeSet.add("cherry");

        System.out.println("[c-f 사이의 단어 검색]");
        NavigableSet<String> rangeSet = treeSet.subSet("c",true, "f", true);
        for(String word : rangeSet) {
            System.out.println(word);
        }
    }
}
