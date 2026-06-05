package com.gary.designpattern.carpicker.parts

class Engine(
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
}