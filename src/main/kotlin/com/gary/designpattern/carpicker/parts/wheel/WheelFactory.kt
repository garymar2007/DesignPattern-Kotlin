package com.gary.designpattern.carpicker.parts.wheel

class WheelFactory(
    val type: Wheel.Type
) {
    fun createWheel(): Wheel = Wheel(type)
}