package chaptor.thread.ControllThreadState.SleepMethod;

import chaptor.BasicExample;

import java.awt.*;

public class SleepExample extends BasicExample {
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
