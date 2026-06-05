package com.gary.designpattern.carpicker.parts

class Wheel : Part {
    override val selfPrice: Int
        get() = 12000

    override val totalPrice: Int = this.selfPrice
}