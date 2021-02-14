package com.bw;

import java.awt.*;

/*
    비프음을 들려주는 작업
 */
public class BeepTask implements Runnable{

    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i =0; i<5; i++) {
            toolkit.beep();
            try{Thread.sleep(500);}
            catch (Exception e){}
        }
    }
}
