package com.gary.designpattern.strategy;

public class Dog implements MyComparable{
    int size;

    public Dog(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "size=" + size +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Dog c = (Dog)o;
        if (this.size < c.size) return -1;
        else if (this.size > c.size) return 1;
        else return 0;
    }
}
