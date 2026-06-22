package com.example.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logger implements the Singleton design pattern.
 *
 * Goals satisfied:
 *  1. Private static reference to the one-and-only instance.
 *  2. Private constructor so no other class can call `new Logger()`.
 *  3. Public static accessor (getInstance) that creates the instance
 *     on first use and returns the same instance on every later call.
 *  4. Thread-safe: uses double-checked locking so multiple threads
 *     can't accidentally create two instances at startup.
 */
public class Logger {

    // 1. The single instance. `volatile` ensures visibility of changes
    //    to this field across threads (required for double-checked locking).
    private static volatile Logger instance;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 2. Private constructor - prevents instantiation from outside this class.
    private Logger() {
        System.out.println("[Logger] New instance created at "
                + dateFormat.format(new Date()) + " by thread "
                + Thread.currentThread().getName());
    }

    // 3. Public static accessor.
    //    Double-checked locking: avoids the cost of synchronizing on every
    //    call, while still being safe the first time the instance is built.
    public static Logger getInstance() {
        if (instance == null) {                  // first check (no lock - fast path)
            synchronized (Logger.class) {
                if (instance == null) {          // second check (inside lock)
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
