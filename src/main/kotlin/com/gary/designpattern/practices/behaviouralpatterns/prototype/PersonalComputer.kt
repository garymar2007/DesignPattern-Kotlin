package com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.prototype

data class PersonalComputer(
    val motherBoard: String = "Tersus XZ27",
    val ram: String = "8GB Microcend BBR5",
    val graphicsCard: String = "Nvidia GeForce GTX 1050",
)

fun main(args: Array<String>) {
    val pc = PersonalComputer().copy(ram = "16GB BBR6")
    println(pc)
}