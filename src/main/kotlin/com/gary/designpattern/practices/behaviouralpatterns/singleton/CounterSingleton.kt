package com.gary.designpattern.practices.behaviouralpatterns.singleton

import java.util.concurrent.atomic.AtomicInteger

// Singleton in Kotlin is object, which cannot have constructor.
object CounterSingleton {
    private val counter = AtomicInteger(0)

    fun increment(): Int = counter.incrementAndGet()
}

fun main(args: Array<String>) {
    for (i in 1..10) {
        println(CounterSingleton.increment())
    }
}