package Basics4;

import java.util.LinkedList;
import java.util.Queue;

public class DataBuffer<T> {

    private final int size;
    private final Queue<T> data;
    private int currentProducers;

    public DataBuffer(int size) {
        this.size = size;
        data = new LinkedList<>();
        currentProducers = 0;
    }

    public synchronized T get() throws BufferFinishedException {
        if(currentProducers == 0 && data.size() == 0) throw new BufferFinishedException("No producers adding data");
        while(data.size() == 0){
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        notifyAll();
        return data.remove();
    }

    public synchronized void put(T e){
        while(data.size() >= size){
            try{
                wait();
            } catch (InterruptedException ignored) {}
        }
        data.add(e);
        notifyAll();
    }

    public synchronized void registerProducer(){ // could switch to hashList but this suffices for now
        currentProducers++;
    }

    public synchronized void producerFinished(){
        currentProducers--;
    }




}
