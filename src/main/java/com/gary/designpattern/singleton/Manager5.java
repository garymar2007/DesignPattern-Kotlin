package com.gary.designpattern.singleton;

/**
 * Lazy loading with synchronized block inside method and with double check.
 *
 */
public class Manager5 {
    // NB: JIT (optimization) compiler translate Java to native code(e.g.: C) and
    // there will be an issue for instruction re-arrangement without volatile.
    private static volatile Manager5 INSTANCE;

    private Manager5() {}

    public static Manager5 getInstance() {
        // Double check hereby is to make sure the INSTANCE is null, then create a single instance.
        if (INSTANCE == null) {
            synchronized (Manager5.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Manager5();
                }
            }
        }

        return INSTANCE;
    }

    // test that this is thread-safe.
    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            // the lambda is used hereby to simplify an anonymous class with only one method.
            new Thread(() -> {
                System.out.println(Manager5.getInstance().hashCode());
            }).start();
        }
    }
}

