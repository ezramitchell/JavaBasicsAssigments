package Basics4;

import java.util.Objects;

public class Producer<T> extends Thread{

    private final DataBuffer<T> buffer;
    private final T value;

    public Producer(DataBuffer<T> buffer1, T value1) {
        this.buffer = buffer1;
        this.value = value1;
        this.buffer.registerProducer();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            buffer.put(value);
        }
        this.buffer.producerFinished();
    }

}
