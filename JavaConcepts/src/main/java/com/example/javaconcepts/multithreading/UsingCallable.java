package com.example.javaconcepts.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class UsingCallable {

    public static void main(String[] args){

        /*
         * Multithreading using Callable
         */
        Callable<Integer> task = () -> {

            Thread.sleep(2000);
            return 10 + 20;
        };

        ExecutorService ex = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> res = ex.submit(task);
            System.out.println("Callable thread starts : " + LocalDateTime.now());
            Thread.sleep(1000);
            System.out.println("Callable Status : " + res.isDone());

            System.out.println("Callable returns :" + res.get() + " at: "+ LocalDateTime.now());
            System.out.println("Callable Status : " + res.isDone());



        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            ex.shutdown();
        }

    }
}
