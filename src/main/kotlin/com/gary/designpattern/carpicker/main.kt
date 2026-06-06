package com.gary.designpattern.carpicker

import com.gary.designpattern.carpicker.parts.Chasis
import com.gary.designpattern.carpicker.parts.Engine
import com.gary.designpattern.carpicker.parts.Transmission
import com.gary.designpattern.carpicker.parts.WheelBase
import com.gary.designpattern.carpicker.parts.seat.Seat
import com.gary.designpattern.carpicker.parts.wheel.Wheel
import com.gary.designpattern.carpicker.vehicle.Vehicle

class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World!")

            // Apply the composition pattern
            // Key takeaway: the parts are independent of each other,
            // and the vehicle is composed of the parts.
            // This allows for flexibility in creating different vehicles with different combinations of parts.
            val byd = Vehicle(
                WheelBase(
                    size = WheelBase.Size.SMALL,
                    chasis = Chasis(
                        type = Chasis.Type.SEDAN,
                        seatFactory = Seat.Factory(Seat.Upholstery.LEATHER)
                    ),
                    wheelFactory = Wheel.Factory(Wheel.Type.STEEL),
                    spareWheel = true,
                ),
                Engine(
                    type = Engine.Type.ELECTRIC,
                    transmission = Transmission(type = Transmission.Type.FWD)
                )
            )

            val hondaCity = Vehicle(
                WheelBase(
                    size = WheelBase.Size.MEDIUM,
                    chasis = Chasis(
                        type = Chasis.Type.SEDAN,
                        seatFactory = Seat.Factory(Seat.Upholstery.FABRIC)
                    ),
                    wheelFactory = Wheel.Factory(Wheel.Type.ALLOY)
                ),
                Engine(
                    type = Engine.Type.DIESEL,
                    transmission = Transmission(type = Transmission.Type.FWD)
                )
            )

            val BMWX7 = Vehicle(
                WheelBase(
                    size = WheelBase.Size.LARGE,
                    chasis = Chasis(
                        type = Chasis.Type.SUV,
                        seatFactory = Seat.Factory(Seat.Upholstery.VINYL)
                    ),
                    wheelFactory = Wheel.Factory(Wheel.Type.CARBONFIBRE),
                    spareWheel = true,
                ),
                Engine(
                    type = Engine.Type.HYBRID,
                    transmission = Transmission(type = Transmission.Type.AWD)
                )
            )
            println("The price for Honda City is: R" + hondaCity.price)
            println("The price for BYD is: R" + byd.price)
            println("The price for BMW X7 is: R" + BMWX7.price)
        }
    }
}