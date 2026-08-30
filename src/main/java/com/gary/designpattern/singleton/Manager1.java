package com.gary.designpattern.singleton;

/**
 * Method 1: static instance and private constructor
 */
public class Manager1 {
    private static final Manager1 INSTANCE = new Manager1();

    private Manager1() {}

    public static Manager1 getInstance() {
        return INSTANCE;
    }

    public void m() { System.out.println("m"); }

    public static void main(String... args) {
        Manager1 m1 = Manager1.getInstance();
        Manager1 m2 = Manager1.getInstance();
        System.out.println(m1 == m2);
    }
}
