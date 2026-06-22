# SingletonPatternExample

A minimal Java project demonstrating the **Singleton design pattern** with a
`Logger` utility class.

## Project Structure
```
SingletonPatternExample/
└── src/
    └── com/example/singleton/
        ├── Logger.java         <- the Singleton class
        └── SingletonTest.java  <- verifies the pattern works
```

## How `Logger` implements Singleton
1. **Private static instance** — `private static volatile Logger instance;`
2. **Private constructor** — `private Logger() { ... }` so no other class can
   call `new Logger()`.
3. **Public static accessor** — `public static Logger getInstance()` creates
   the instance the first time it's called and returns that same instance on
   every later call.
4. **Thread safety** — uses *double-checked locking* (the two `if (instance == null)`
   checks plus `synchronized`) so concurrent threads can't race and create two
   instances. `volatile` guarantees every thread sees the fully-constructed
   object once it's assigned.

## How to compile and run
From the project root:

```bash
mkdir -p bin
javac -d bin src/com/example/singleton/*.java
java -cp bin com.example.singleton.SingletonTest
```

## What the test verifies
- **Test 1:** Calls `Logger.getInstance()` twice and confirms both
  references are `==` (the same object), and that they share the same
  `hashCode()`.
- **Test 2:** Spins up 10 threads that all call `Logger.getInstance()` at
  the same time, then checks that every thread received the exact same
  instance — proving the lazy initialization is safe under concurrency.

Sample output:
```
=== Test 1: Basic Singleton Check ===
[Logger] New instance created at ...
logger1 == logger2 ? true
PASS: Only one instance exists.

=== Test 2: Multithreaded Singleton Check ===
All 10 thread instances identical? true
PASS: Singleton holds under concurrent access.
```

Note only **one** "New instance created" line ever prints, even though
`getInstance()` is called 12 times total across both tests — confirming the
Singleton contract holds.
