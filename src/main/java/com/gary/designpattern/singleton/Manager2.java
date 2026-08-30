package com.gary.designpattern.singleton;

/**
 * Lazy loading singleton, but this is not thread-safe due to the instance creation.
 */
public class Manager2 {
    private static Manager2 INSTANCE;

    private Manager2() {}

    public static Manager2 getInstance() {
        if (INSTANCE == null) {
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager2();
        }

        return INSTANCE;
    }

    // test that this is not thread-safe.
    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            // the lambda is used hereby to simplify an anonymous class with only one method.
            new Thread(() -> {
                System.out.println(Manager2.getInstance().hashCode());
            }).start();
        }
    }
}
