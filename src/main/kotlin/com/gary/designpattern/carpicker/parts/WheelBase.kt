package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.wheel.Wheel

class WheelBase(
    val size: Size,
    val chasis: Chasis,
    val wheelFactory: Wheel.Factory,
    val spareWheel: Boolean = false,
) : Part {
    val numberOfWheels = when(this.size) {
        Size.SMALL -> 2
        Size.MEDIUM -> 4
        Size.LARGE -> 6
    }

    val totalNumberOfWheels = if(this.spareWheel) numberOfWheels + 1 else numberOfWheels

    val wheels: List<Wheel> = generateSequence {
        wheelFactory.createWheel()
    }.take(totalNumberOfWheels).toList()

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