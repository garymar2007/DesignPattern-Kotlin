package com.gary.designpattern.singleton;

/**
 * Lazy loading with synchronized method.
 * However, performance is comprised.
 */
public class Manager4 {
    private static Manager4 INSTANCE;

    private Manager4() {}

    public static synchronized Manager4 getInstance() {
        if (INSTANCE == null) {
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager4();
        }

        return INSTANCE;
    }

    // test that this is thread-safe.
    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            // the lambda is used hereby to simplify an anonymous class with only one method.
            new Thread(() -> {
                System.out.println(Manager4.getInstance().hashCode());
            }).start();
        }
    }
}
