package chaptor.thread.BeepPrintExample;

public class BeepPrintExample3 {

    public void beepPrint() {
        Thread thread = new BeepThread();
        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            }
            catch (Exception e) {

            }
        }
    }
}
