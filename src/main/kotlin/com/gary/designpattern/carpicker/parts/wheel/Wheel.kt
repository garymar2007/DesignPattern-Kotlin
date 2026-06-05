package com.gary.designpattern.carpicker.parts.wheel

import com.gary.designpattern.carpicker.parts.Part

class Wheel(
    val type: Type
) : Part {
    override val selfPrice: Int
        get() = when(this.type) {
            Type.STEEL -> 10000
            Type.ALLOY -> 11000
            Type.CARBONFIBRE -> 20000
        }

    override val totalPrice: Int = this.selfPrice

    enum class Type { STEEL, ALLOY, CARBONFIBRE }

    class Factory(
        val type: Type
    ) {
        fun createWheel(): Wheel = Wheel(type)
    }
}