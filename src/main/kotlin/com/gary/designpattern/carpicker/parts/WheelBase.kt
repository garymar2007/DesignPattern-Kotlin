package com.gary.designpattern.carpicker.parts

import com.gary.designpattern.carpicker.parts.wheel.Wheel

class WheelBase private constructor(
    val size: Size,
    val wheels: List<Wheel>,
) : Part {

    override val selfPrice: Int
        get() = when (this.size) {
            Size.SMALL -> 10000
            Size.MEDIUM -> 11000
            Size.LARGE -> 12000
        }

    override val totalPrice: Int
        get() = this.selfPrice + this.wheels.sumOf { it.totalPrice }

    enum class Size {
        SMALL, MEDIUM, LARGE
    }

    class Builder {
        lateinit var size: Size
        lateinit var wheelFactory: Wheel.Factory
        var spareWheel: Boolean = false

        fun setSize(size: Size): Builder {
            this.size = size
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
            return WheelBase(this.size, this.wheelFactory.createWheel(
                4 + if (this.spareWheel) 1 else 0
            ))
        }
    }
}