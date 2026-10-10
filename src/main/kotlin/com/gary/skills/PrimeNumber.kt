package com.gary.skills

import java.lang.Math.ceil
import java.lang.Math.sqrt

fun Int.isPrime(): Boolean = this == 2 ||
        (2..ceil(sqrt(this.toDouble())).toInt()).none { divisor -> this % divisor == 0 }

fun nextPrime(num: Int) =
    generateSequence(num + 1) { it + 1 }
        .first(Int::isPrime)

fun firstNPrimes(count: Int) =
    generateSequence(2, ::nextPrime)
        .take(count)
        .toList()

fun primesLessThan(max: Int): List<Int> =
    // the sequence is terminated by a null is returned
    generateSequence(2) { n -> if (n < max) nextPrime(n) else null }
        .toList().dropLast(1)

fun primesLessThanV2(max: Int): List<Int> =
    generateSequence(2, ::nextPrime)
        .takeWhile { it < max }
        .toList()

fun main() {
    println(3748.isPrime())
    val nextPrime = nextPrime(3760)
    println(nextPrime)
    println(firstNPrimes(5))
    println(primesLessThan(20))
    println(primesLessThanV2(20))
}