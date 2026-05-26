package concepts.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingExecutorService {

    public static void main(String[] args){

        /*
         * Multithreading using Executor
         */
        System.out.println("Executor Thread Starts : " + LocalDateTime.now());
        ExecutorService ex = Executors.newFixedThreadPool(3);

        ex.submit(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executor Thread ends : " + LocalDateTime.now());
        });

        ex.shutdown();
    }
}
