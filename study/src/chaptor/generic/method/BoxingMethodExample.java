package chaptor.generic.method;

import chaptor.BasicExample;
import chaptor.generic.type.Box;

public class BoxingMethodExample extends BasicExample {
    @Override
    public void run() {
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.getT();

        Box<String> box2 = Util.boxing("홍길동");
        String strValue = box2.getT();
    }
}
