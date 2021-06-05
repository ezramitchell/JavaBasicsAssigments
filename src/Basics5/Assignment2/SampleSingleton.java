package Basics5.Assignment2;

import Basics4.Singleton;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class SampleSingleton {

    private static Connection conn = null;

    private static SampleSingleton instance = null;

    private SampleSingleton(){ //add private constructor

    }

    public static SampleSingleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){ //lock whole class because static methods can't be locked and instance is null
                if(instance == null){
                    instance = new SampleSingleton();
                }
            }
        }
        return instance;
    }

}
