package org.example.multithreading.counter;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.*;
class DoSomethingInAThread implements Runnable {
    CountDownLatch latch;
    public DoSomethingInAThread(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try {
            System.out.println("Do some thing " +Thread.currentThread().getName() );
            latch.countDown();
            System.out.println("after countDown "+ Thread.currentThread().getName()+" " + new Date().getTime());
            System.out.println(Thread.currentThread().getName()+" " + new Date().getTime());
        } catch(Exception err) {
            err.printStackTrace();
        }
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) {
        try {
            int numberOfThreads = 5;

            CountDownLatch latch = new CountDownLatch(numberOfThreads);
            for (int n = 0; n < numberOfThreads; n++) {
                Thread t = new Thread(new DoSomethingInAThread(latch));
                t.start();
            }
            latch.await();
            System.out.println("In Main thread after completion of " + numberOfThreads + " threads " + new Date().getTime());
        } catch(Exception err) {
            err.printStackTrace();
        }
    }
}