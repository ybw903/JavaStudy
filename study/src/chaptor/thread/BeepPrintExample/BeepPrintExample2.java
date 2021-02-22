package chaptor.thread.BeepPrintExample;

/*
    메인 스레드와 작업 스레드가 동시에 실행
 */
public class BeepPrintExample2 {

    public void beepPrint(){
        
        //Runnable 익명 객체 사용 또는 람다식을 이용하여 작업 스러데 생성가능
        Runnable beepTask = new BeepTask();
        Thread thread = new Thread(beepTask);
        thread.start();

        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try{Thread.sleep(500);}
            catch (Exception e){}
        }
    }
}
