package Basics4;

public class Singleton {
    private static Singleton instance;

    public String data;
    private Singleton(){
        data = "I'm a singleton!"; //this was just to make my warnings go away
    }

    public static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){ //lock whole class because static methods can't be locked and instance is null
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
