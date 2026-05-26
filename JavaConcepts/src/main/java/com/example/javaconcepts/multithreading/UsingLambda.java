package com.example.javaconcepts.multithreading;

import java.time.LocalDateTime;

public class UsingLambda {

    public static void main(String[] args){

        /*
         * Multithreading using lambda
         */
        System.out.println("Lambda Threads starts: " + LocalDateTime.now());
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Lambda Thread Ends: " + LocalDateTime.now());
        });

        t.start();
    }
}
