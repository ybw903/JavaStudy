package chaptor.collectionFramework.treeCollection;

import chaptor.BasicExample;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample2 extends BasicExample {
    @Override
    public void run() {
        TreeSet<Integer> scores = new TreeSet<Integer>();
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        NavigableSet<Integer> descendingSet = scores.descendingSet();
        for(Integer score : descendingSet) {
            System.out.println(score + " ");
        }
        System.out.println();

        NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();

        for(Integer score : ascendingSet) {
            System.out.println(score + " ");
        }
    }
}
