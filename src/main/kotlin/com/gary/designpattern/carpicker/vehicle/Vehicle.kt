package com.gary.designpattern.carpicker.vehicle

import com.gary.designpattern.carpicker.parts.Engine
import com.gary.designpattern.carpicker.parts.WheelBase

class Vehicle(
    val wheelBase: WheelBase,
    val engine: Engine
) {
    val price: Int = wheelBase.totalPrice + engine.totalPrice
}