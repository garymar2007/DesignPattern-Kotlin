package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.seat.Seat

class Chasis(val type: Type) : Part {
    val seats: List<Seat> = listOf(
        Seat(), Seat(), Seat(), Seat()
    )

    override val selfPrice: Int
        get() = when(this.type) {
            Type.SEDAN -> 150000
            Type.SUV -> 200000
            Type.HATCHBACK -> 250000
            Type.PICKUP -> 350000
        }

    override val totalPrice: Int
        get() = this.selfPrice + this.seats.sumOf { it.totalPrice }

    enum class Type {
        SEDAN, SUV, HATCHBACK, PICKUP
    }
}