package com.gary.designpattern.practices.behaviourpattern.factory

/**
 *   像 Java 中的静态方法一样，调用companion对象不需要实例化一个类：
 *
 * println(NumberMaster.valueOf("123")) // Prints 123
 * 此外，直接在类的实例上调用它将不起作用，这与 Java 不同：
 *
 * println(NumberMaster().valueOf("123")) // Won't compile
 */
class StaticFactory private constructor() {
    companion object {
        fun create(): StaticFactory = StaticFactory()
    }
}

fun main(args: Array<String>) {
    val factory = StaticFactory.create()
}