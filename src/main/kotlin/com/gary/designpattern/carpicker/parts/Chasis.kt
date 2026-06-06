package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.seat.Seat

class Chasis private constructor(
    val type: Type,
    val seatFactory: Seat.Factory,
) : Part {
    val numberOfSeats = when(this.type) {
        Type.SEDAN -> 5
        Type.SUV -> 8
        Type.HATCHBACK -> 4
        Type.PICKUP -> 6
    }

    val seats: List<Seat> = generateSequence {
        seatFactory.createSeat()
    }.take(numberOfSeats)
        .toList()

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

    class Builder {
        lateinit var chasisType: Type
        lateinit var seatFactory: Seat.Factory

        fun setChasisType(chasisType: Type): Builder {
            this.chasisType = chasisType
            return this
        }

        fun setSeatFactory(seatFactory: Seat.Factory): Builder {
            this.seatFactory = seatFactory
            return this
        }

        fun build(): Chasis {
            return Chasis(this.chasisType, this.seatFactory)
        }
    }
}