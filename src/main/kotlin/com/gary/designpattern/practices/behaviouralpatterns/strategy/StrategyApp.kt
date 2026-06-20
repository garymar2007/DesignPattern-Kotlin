package com.gary.designpattern.practices.behaviouralpatterns.strategy

import com.gary.designpattern.practices.behaviouralpatterns.strategy.StrategyApp.Addition
import com.gary.designpattern.practices.behaviouralpatterns.strategy.StrategyApp.Calculator
import com.gary.designpattern.practices.behaviouralpatterns.strategy.StrategyApp.Multiplication
import com.gary.designpattern.practices.behaviouralpatterns.strategy.StrategyApp.Subtraction

class StrategyApp {
    interface CalculateStrategy {
        fun calculate(a: Int, b: Int): Int
    }

    class Addition: CalculateStrategy {
        override fun calculate(a: Int, b: Int): Int = a + b
    }

    class Subtraction: CalculateStrategy {
        override fun calculate(a: Int, b: Int): Int = a - b
    }

    class Multiplication: CalculateStrategy {
        override fun calculate(a: Int, b: Int): Int = a * b
    }

    class Calculator(private val strategy: CalculateStrategy) {
        fun calculate(a: Int, b: Int) = strategy.calculate(a, b)
    }
}

fun main() {
    val calculator = Calculator(Addition())
    println(calculator.calculate(1, 2))
    val calculator2 = Calculator(Subtraction())
    println(calculator2.calculate(2, 3))
    val calculator3 = Calculator(Multiplication())
    println(calculator3.calculate(3, 4))

}