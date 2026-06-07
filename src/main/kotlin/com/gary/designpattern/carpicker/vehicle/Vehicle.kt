package com.gary.designpattern.carpicker.vehicle

import com.gary.designpattern.carpicker.parts.Chasis
import com.gary.designpattern.carpicker.parts.Engine
import com.gary.designpattern.carpicker.parts.WheelBase

class Vehicle private constructor(
    val wheelBase: WheelBase,
    val chasis: Chasis,
    val engine: Engine
) {
    val price: Int = wheelBase.totalPrice + chasis.totalPrice + engine.totalPrice

    val totalNumberOfSeats: Int = this.chasis.seats.size

    val totalNumberOfWheels: Int = this.wheelBase.wheels.size

    class Builder {
        private lateinit var wheelBase: WheelBase
        private lateinit var chasis: Chasis
        private lateinit var engine: Engine

        fun setWheelBase(wheelBase: WheelBase): Builder {
            this.wheelBase = wheelBase
            return this
        }

        fun setChasis(chasis: Chasis): Builder {
            this.chasis = chasis
            return this
        }

        fun setEngine(engine: Engine): Builder {
            this.engine = engine
            return this
        }

        fun build(): Vehicle {
            return Vehicle(this.wheelBase, this.chasis, this.engine)
        }
    }
}