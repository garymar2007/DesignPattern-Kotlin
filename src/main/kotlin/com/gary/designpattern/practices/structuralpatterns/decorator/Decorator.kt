package com.gary.designpattern.practices.structuralpatterns.decorator

class Decorator {
}

class HappyMap<K,V> : HashMap<K,V>() {
    override fun put(key: K, value: V): V? {
        return super.put(key, value).apply {
            this?.let { println("Key $key is updated to $value") }
        }
    }
}

class HappyMap2<K,V>(
    private val map: MutableMap<K,V> = mutableMapOf()
): MutableMap<K,V> by map {
    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            this?.let { println("Key $key is updated to $value") }
        }
    }
}

class SadMap<K,V>(
    private val map: MutableMap<K,V> = mutableMapOf()
): MutableMap<K,V> by map {
    override fun remove(key: K): V? {
        return map.remove(key).apply {
            this?.let { println("Key $key and $it is removed") }
        }
    }
}


fun main(args: Array<String>) {
    val happyMap = HappyMap<Int,String>()
    happyMap[1] = "Hello"
    happyMap[2] = "World"
    happyMap[2] = "Kotlin"

    val happyMap2 = HappyMap2<Int,String>()
    val sadHappy = SadMap(happyMap2)
    sadHappy[1] = "Kotlin"
    sadHappy[2] = "Java"
    sadHappy[2] = "Python"
    sadHappy.remove(2)
}