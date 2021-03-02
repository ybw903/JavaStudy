package chaptor.generic.type;

import chaptor.BasicExample;

public class BoxExample extends BasicExample {
    @Override
    public void run() {
        Box box = new Box();
        Box<String> box1= new Box<String>();
        box1.setT("hello");
        String str = box1.getT();

        Box<Integer> box2 = new Box<Integer>();
        box2.setT(6);
        int value = box2.getT();
     }
}
