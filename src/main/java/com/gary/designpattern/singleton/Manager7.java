package com.gary.designpattern.singleton;

/**
 * Using enum to implement a singleton.
 * There will be no deserialization for enum class due to no constructor
 *
 */
public enum Manager7 {

    INSTANCE;

    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            // the lambda is used hereby to simplify an anonymous class with only one method.
            new Thread(() -> {
                System.out.println(Manager7.INSTANCE.hashCode());
            }).start();
        }
    }
}

