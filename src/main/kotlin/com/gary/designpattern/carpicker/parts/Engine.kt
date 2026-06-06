package com.gary.designpattern.carpicker.parts

class Engine private constructor(
    val type: Type,
    val transmission: Transmission
) : Part {
    override val selfPrice: Int
        get() = when(this.type) {
            Type.DIESEL -> 100000
            Type.GASOLINE -> 200000
            Type.HYBRID -> 500000
            Type.ELECTRIC -> 400000
        }

    override val totalPrice: Int
        get() = this.selfPrice + this.transmission.totalPrice

    enum class Type {
        DIESEL, GASOLINE, HYBRID, ELECTRIC
    }

    class Builder {
        lateinit var engineType: Type
        lateinit var transmission: Transmission.Type

        fun setEngineType(engineType: Type): Builder {
            this.engineType = engineType
            return this
        }

        fun setTransmission(transmission: Transmission.Type): Builder {
            this.transmission = transmission
            return this
        }

        fun build(): Engine {
            return Engine(this.engineType, Transmission(this.transmission))
        }
    }
}