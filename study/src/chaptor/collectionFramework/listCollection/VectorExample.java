package chaptor.collectionFramework.listCollection;

import chaptor.BasicExample;

import java.util.List;
import java.util.Vector;

public class VectorExample extends BasicExample {
    @Override
    public void run() {
        List<Board> list = new Vector<Board>();

        for (int i = 1; i<= 5; i++) {
            list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
        }

        list.remove(2);
        list.remove(3);

        for(int i=0; i<list.size(); i++) {
            Board board = list.get(i);
            System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
        }
    }
}
