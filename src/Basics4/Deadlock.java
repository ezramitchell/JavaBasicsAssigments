package Basics4;

public class Deadlock {

    public static Object value1 = new Object();
    public static Object value2 = new Object();
    public static void main(String[] args) {
        //create deadlock
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();

        t2.start();
        t1.start();

    }

    private static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (value1){
                System.out.println("Thread 1 holding value 1");
                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (value2){
                    System.out.println("Thread 1 holding value 2");
                }
            }
        }
    }

    private static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (value2){
                System.out.println("Thread 2 holding value 2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (value1){
                    System.out.println("Thread 2 holding value 1");
                }
            }
        }


}


}