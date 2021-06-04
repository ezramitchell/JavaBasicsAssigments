package Basics4;

public class PCMain {

    public static void main(String[] args) {
        DataBuffer<Character> buffer = new DataBuffer<>(7);
        //make producers
        Producer<Character> p1 = new Producer<>(buffer, '1');
        Producer<Character> p2 = new Producer<>(buffer, '2');
        Producer<Character> p3 = new Producer<>(buffer, '3');
        //make consumers
        Consumer<Character> c1 = new Consumer<>(buffer, "Consumer 1");
        Consumer<Character> c2 = new Consumer<>(buffer, "Consumer 2");
        Consumer<Character> c3 = new Consumer<>(buffer, "Consumer 3");

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();
    }
}
