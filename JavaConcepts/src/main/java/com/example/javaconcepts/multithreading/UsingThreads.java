package concepts.multithreading;

import java.time.LocalDateTime;

public class UsingThreads {

    public static void main(String[] args){

        /*
         * Multithreading extending Thread class
         * This do not allow us to extend multiple class
         * Need to implement run() method where multithreading task is defined
         *
         * start() method runs the required task i.e. run() method
         */

        RunThread rt = new RunThread();
        System.out.println("Threads starts: "+ LocalDateTime.now());
        rt.start();
        System.out.println("Multithreading is already started.");
    }


}

class RunThread extends Thread {
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("Thread Ends: "+ LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}