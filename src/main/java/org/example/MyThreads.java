package org.example;

public class MyThreads {
    private static class MyDaemonThread extends Thread {
        public MyDaemonThread() {
            setDaemon(true);
        }
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("Daemon thread");

            } catch (InterruptedException e) {
            }
        }
    }

    private static class BasicThread extends Thread {
        public BasicThread() {
        }
        @Override
        public void run() {
            try {

                Thread.sleep(1000);
                System.out.println("Basic thread");
            } catch (InterruptedException e) {
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyDaemonThread();
        Thread basic = new BasicThread();

        thread.start();
        basic.start();
        System.out.println(basic.isAlive());

        thread.join();
    }
}
