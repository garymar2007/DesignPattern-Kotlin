package com.gary.designpattern.strategy;

public class Dog implements MyComparable<Dog>{
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
    public int compareTo(Dog o) {
        if (this.size < o.size) return -1;
        else if (this.size > o.size) return 1;
        else return 0;
    }
}
