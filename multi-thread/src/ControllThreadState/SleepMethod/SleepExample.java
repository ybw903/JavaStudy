package ControllThreadState.SleepMethod;

import java.awt.*;

public class SleepExample {
    public void sleepExampleRun(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++){
            toolkit.beep();
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {}
        }
    }
}
