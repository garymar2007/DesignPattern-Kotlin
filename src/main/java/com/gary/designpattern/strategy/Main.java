package com.gary.designpattern.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        //int[] a = {9, 2, 3, 7, 5, 1, 4};
        Cat[] a = {new Cat(5,5), new Cat(1, 1), new Cat(3, 3), new Cat(2,2)};
        Dog[] d = {new Dog(5), new Dog(1), new Dog(3), new Dog(2)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
        sorter.sort(d);
        System.out.println(Arrays.toString(d));
    }
}
