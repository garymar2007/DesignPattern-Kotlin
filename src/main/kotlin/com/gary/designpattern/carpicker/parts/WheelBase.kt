package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.wheel.Wheel

class WheelBase private constructor(
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

    class Builder {
        lateinit var size: Size
        lateinit var chasis: Chasis
        lateinit var wheelFactory: Wheel.Factory
        var spareWheel: Boolean = false

        fun setSize(size: Size): Builder {
            this.size = size
            return this
        }

        fun setChasis(chasis: Chasis): Builder {
            this.chasis = chasis
            return this
        }

        fun setWheelFactory(wheelFactory: Wheel.Factory): Builder {
            this.wheelFactory = wheelFactory
            return this
        }

        fun setSpareWheel(spareWheel: Boolean): Builder {
            this.spareWheel = spareWheel
            return this
        }

        fun build(): WheelBase {
            return WheelBase(this.size, this.chasis, this.wheelFactory, this.spareWheel)
        }
    }
}