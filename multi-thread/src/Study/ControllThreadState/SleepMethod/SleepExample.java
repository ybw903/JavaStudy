package Study.ControllThreadState.SleepMethod;

import Study.BasicTest;

import java.awt.*;

public class SleepExample extends BasicTest {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++){
            toolkit.beep();
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {}
        }
    }

}
