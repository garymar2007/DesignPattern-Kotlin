package com.gary.designpattern.carpicker.parts.seat

import com.gary.designpattern.carpicker.parts.Part

class Seat : Part {

    override val selfPrice: Int
        get() = 1500

    override val totalPrice: Int = this.selfPrice
}