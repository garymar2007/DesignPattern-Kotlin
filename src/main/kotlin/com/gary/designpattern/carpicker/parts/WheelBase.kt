package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.wheel.Wheel
import com.gary.designpattern.carpicker.parts.wheel.WheelFactory

class WheelBase(
    val size: Size,
    val chasis: Chasis,
    val wheelFactory: WheelFactory,
) : Part {
    val wheels: List<Wheel> = listOf(
        wheelFactory.createWheel(),
        wheelFactory.createWheel(),
        wheelFactory.createWheel(),
        wheelFactory.createWheel()
    )

    override val selfPrice: Int
        get() = when (this.size) {
            Size.SMALL -> 10000
            Size.MEDIUM -> 11000
            Size.LARGE -> 12000
        }

    override val totalPrice: Int
        get() = this.selfPrice + this.chasis.totalPrice + this.wheels.sumOf { it.totalPrice }

    enum class Size {
        SMALL, MEDIUM, LARGE
    }
}