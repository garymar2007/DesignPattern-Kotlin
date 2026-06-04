package com.gary.designpattern.carpicker.parts

class WheelBase : Part {
    val chasis: Chasis = Chasis()
    val wheels: List<Wheel> = listOf(
        Wheel(), Wheel(), Wheel(), Wheel()
    )

    override val price: Int
        get() = 120000
}