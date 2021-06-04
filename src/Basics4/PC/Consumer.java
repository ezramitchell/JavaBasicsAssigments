package Basics4.PC;

public class Consumer<T> extends Thread {

    private final DataBuffer<T> buffer;
    private final String name;
    private boolean finished = false;

    public Consumer(DataBuffer<T> buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        while (!finished) {
            try {
                System.out.printf("%s got %s%n", name, buffer.get());
            } catch (BufferFinishedException e) {
                System.out.printf("%s is finished%n", name);
                finished = true;
            }
        }
    }
}
