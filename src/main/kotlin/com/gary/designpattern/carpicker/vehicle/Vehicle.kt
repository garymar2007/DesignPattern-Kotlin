package com.gary.designpattern.carpicker.vehicle

import com.gary.designpattern.carpicker.parts.Engine
import com.gary.designpattern.carpicker.parts.WheelBase

class Vehicle {
    var wheelBase: WheelBase = WheelBase()
    val engine: Engine = Engine()

    val price: Int get() =
        wheelBase.price + wheelBase.chasis.price + wheelBase.chasis.seats.sumOf { it.price } + wheelBase.wheels.sumOf { it.price } + engine.price + engine.transmission.price
}