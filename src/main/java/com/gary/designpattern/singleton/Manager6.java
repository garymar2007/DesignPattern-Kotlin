package com.gary.designpattern.singleton;

/**
 * Static inner class where a single instance is initialized - this is the perfect way without any flawness.
 *
 */
public class Manager6 {

    private Manager6() {}

    // NB: the inner static class won't be loaded when the outer class is loaded.
    // So it is lazy loading and safe thread because the JVM ensures the single instance.
    private static class ManagerHolder {
        private final static Manager6 INSTANCE = new Manager6();
    }

    public static Manager6 getInstance() {
        return ManagerHolder.INSTANCE;
    }

    // test that this is thread-safe.
    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            // the lambda is used hereby to simplify an anonymous class with only one method.
            new Thread(() -> {
                System.out.println(Manager6.getInstance().hashCode());
            }).start();
        }
    }
}

