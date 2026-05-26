package concepts.multithreading;

import java.time.LocalDateTime;

public class UsingRunnable {

    public static void main(String[] args){

        /*
         * Multithreading implementing Runnable Interface
         * This allows us to extend a class along with interface
         * The object class that implements Runnable is passed to create a thread object
         *
         * start() method runs the required task i.e. run() method
         */

        Thread t = new Thread(new RunThread2());
        System.out.println("Threads starts: "+ LocalDateTime.now());
        t.start();
        System.out.println("Multithreading is already started.");
    }


}

class RunThread2 implements Runnable {
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("Thread Ends: "+ LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
