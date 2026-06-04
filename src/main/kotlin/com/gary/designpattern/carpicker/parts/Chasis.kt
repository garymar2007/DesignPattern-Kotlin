package com.gary.designpattern.carpicker.parts

class Chasis : Part {
    val seats: List<Seat> = listOf(
        Seat(), Seat(), Seat(), Seat()
    )

    override val price: Int
        get() = 230000
}