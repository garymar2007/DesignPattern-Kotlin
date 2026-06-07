package com.gary.designpattern.carpicker.parts.seat

import com.gary.designpattern.carpicker.parts.Part

class Seat(val upholstery: Upholstery) : Part {

    override val selfPrice: Int
        get() = when(this.upholstery) {
            Upholstery.LEATHER -> 1500
            Upholstery.FABRIC -> 1000
            Upholstery.VINYL -> 500
        }

    override val totalPrice: Int = this.selfPrice

    enum class Upholstery {
        LEATHER, FABRIC, VINYL
    }

    class Factory(
        val upholstery: Upholstery
    ) {
        fun createSeat(numSeats: Int): List<Seat> {
            return generateSequence { Seat(upholstery) }.take(numSeats).toList()
        }
    }
}