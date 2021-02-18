package Study.BeepPrintExample;

import java.awt.*;

/*
    메인 스레드만 이용한 경우
 */
public class BeepPrintExample1 {
    Toolkit toolkit;

    public BeepPrintExample1(){
        this.toolkit = Toolkit.getDefaultToolkit();
    }

    public void beepPrint() {
        for(int i=0; i<5; i++) {
            this.toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        for(int i =0; i<5; i++) {
            System.out.println("띵");
            try{Thread.sleep(500);}catch (Exception e){}
        }
    }
}
