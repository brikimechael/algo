package org.example.multithreading;

public class TestRun implements Runnable{

    Object obj = new Object();

    void outer() throws InterruptedException {
        synchronized (Thread.currentThread()) {
            System.out.println("outer "+Thread.currentThread().getName());
            System.out.println(Thread.holdsLock(obj));
            obj.wait();
            obj.notify();
        }
    }

    @Override
    public void run() {
        System.out.println("run "+Thread.currentThread().getName());
        try {
            outer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String... args){
       Thread testRun = new Thread(new TestRun());
        testRun.run();
        //testRun.run();
        //testRun.start();
    }
}
