package Study.thread.ThreadPool;

import Study.BasicTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample extends BasicTest {
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("[작업 처리 요청]");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=1; i<=10; i++){sum+=i;}
                System.out.println("[처리 결과] " + sum);
            }
        };
        Future future = executorService.submit(runnable);

        try{
            future.get();
            System.out.println("[작업 처리 완료]");
        } catch (Exception e) {
            System.out.println("[실행 예외 발생함] " + e.getMessage());
        }
        executorService.shutdown();
    }
}
