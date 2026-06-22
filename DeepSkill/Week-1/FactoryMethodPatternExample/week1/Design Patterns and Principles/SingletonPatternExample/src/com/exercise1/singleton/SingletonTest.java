package com.exercise1.singleton;
public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Test 1: Basic Singleton Check ===");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message from logger1");
        logger2.log("Second message from logger2");

        System.out.println("logger1 hashCode: " + logger1.hashCode());
        System.out.println("logger2 hashCode: " + logger2.hashCode());
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));

        if (logger1 == logger2) {
            System.out.println("PASS: Only one instance exists.\n");
        } else {
            System.out.println("FAIL: Multiple instances were created!\n");
        }

        System.out.println("=== Test 2: Multithreaded Singleton Check ===");
        final Logger[] instances = new Logger[10];
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                instances[index] = Logger.getInstance();
                instances[index].log("Message from " + Thread.currentThread().getName());
            }, "Worker-" + i);
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        boolean allSame = true;
        for (Logger l : instances) {
            if (l != instances[0]) {
                allSame = false;
                break;
            }
        }

        System.out.println("All 10 thread instances identical? " + allSame);
        if (allSame) {
            System.out.println("PASS: Singleton holds under concurrent access.");
        } else {
            System.out.println("FAIL: Singleton was broken by concurrent access!");
        }
    }
}
