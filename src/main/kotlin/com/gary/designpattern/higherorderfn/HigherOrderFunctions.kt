package com.gary.designpattern.higherorderfn

/**
 * Koglin has first-class support for higher-order functions.
 *
 * concept: Higher-order function
 * A function that takes a function as an argument or returns a function.
 */

// function as an argument.  Kotlin collections have those built-in higher order functions, such as map, filter, reduce.
fun doToEach(items: List<Int>, action: (Int) -> Unit) = items.forEach(action)

// function as a return type
fun multiplier(factor: Int): (Int) -> Int {
    return { n -> n * factor }
}

// real-world example: a reusable logger
// This is a kind of decorator pattern
fun <T> withLogging(fn: (Int, Int) -> T): (Int, Int) -> T {
    return { a, b ->
        println("Running with $a and $b")
        val result = fn(a, b)
        println("Result: $result")
        result
    }
}

// Higher-order functions can be considered as strategy design pattern.
fun sortWith(items: List<Int>, strategy: (Int, Int) -> Boolean): List<Int> {
    return items.sortedWith { a, b -> if (strategy(a, b)) -1 else 1  }
}

// Higher-order functions can be used on Template Method pattern
fun processData(
    data: List<Int>,
    transform: (Int) -> Int,
    filter: (Int) -> Boolean,
): List<Int> {
    return data.map(transform).filter(filter)
}

// Kotlin-specific: let, run, also, and apply -- Kotlin's standard library is full of higher-order functions.

fun main(args: Array<String>) {
    doToEach(listOf(1,2,3,4,5), { println(it) })

    // map
    val doubled = listOf(1,2,3,4,5).map { it * 2 }
    println(doubled)

    // filter
    val even = listOf(1,2,3,4,5).filter { it % 2 == 0 }
    println(even)

    // reduce
    val sum = listOf(1,2,3,4,5).reduce { acc, i -> acc + i }
    println(sum)

    val doubled2 = multiplier(2)
    val triple = multiplier(3)
    println(doubled2(5))
    println(triple(5))

    val add = { a: Int, b: Int -> a + b }
    val add2 = withLogging(add)
    println(add2(1,2))

    val sorted = sortWith(listOf(1,2,3,4,5), { a, b -> a < b })
    println("List in Ascending order: $sorted")
    val sorted2 = sortWith(listOf(1,2,3,4,5), { a, b -> a > b })
    println("List in Descending order: $sorted2")

    val data = listOf(1,2,3,4,5)
    val processedData = processData(data, { it * 2 }, { it >= 5 })
    println(processedData)
}