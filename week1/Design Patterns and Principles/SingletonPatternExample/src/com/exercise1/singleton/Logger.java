package com.exercise1.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
   private static volatile Logger instance;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger() {
        System.out.println("[Logger] New instance created at "
                + dateFormat.format(new Date()) + " by thread "
                + Thread.currentThread().getName());
    }
    public static Logger getInstance() {
        if (instance == null) {                 
            synchronized (Logger.class) {
                if (instance == null) {          
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[" + dateFormat.format(new Date()) + "] LOG: " + message);
    }

    public void error(String message) {
        System.out.println("[" + dateFormat.format(new Date()) + "] ERROR: " + message);
    }
}
