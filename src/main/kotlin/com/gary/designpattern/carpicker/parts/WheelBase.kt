package com.gary.designpattern.carpicker.parts

class WheelBase(
    val size: Size,
    val chasis: Chasis,
) : Part {
    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
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