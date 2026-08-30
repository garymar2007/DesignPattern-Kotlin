package com.gary.designpattern.singleton;

/**
 * Method 3: similiar to method 1, but using the static block
 */
public class Manager3 {
    private static final Manager3 INSTANCE;

    static {
        INSTANCE = new Manager3();
    }

    private Manager3() {}

    public static Manager3 getInstance() {
        return INSTANCE;
    }

    public void m() { System.out.println("m"); }

    public static void main(String... args) {
        Manager3 m1 = Manager3.getInstance();
        Manager3 m2 = Manager3.getInstance();
        System.out.println(m1 == m2);
    }
}
