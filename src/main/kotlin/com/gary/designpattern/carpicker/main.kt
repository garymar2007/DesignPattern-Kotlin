package com.gary.designpattern.carpicker

import com.gary.designpattern.carpicker.vehicle.Vehicle

class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World!")

            val vehicle = Vehicle()
            println(vehicle.price)
        }
    }
}