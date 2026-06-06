package com.gary.designpattern.carpicker

import com.gary.designpattern.carpicker.parts.Chasis
import com.gary.designpattern.carpicker.parts.Engine
import com.gary.designpattern.carpicker.parts.Transmission
import com.gary.designpattern.carpicker.parts.WheelBase
import com.gary.designpattern.carpicker.parts.seat.Seat
import com.gary.designpattern.carpicker.parts.wheel.Wheel
import com.gary.designpattern.carpicker.vehicle.Vehicle
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.terminal.prompt


class Main {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World!")

            // Apply the composition pattern
            // Key takeaway: the parts are independent of each other,
            // and the vehicle is composed of the parts.
            // This allows for flexibility in creating different vehicles with different combinations of parts.
//            val byd = Vehicle(
//                WheelBase(
//                    size = WheelBase.Size.SMALL,
//                    chasis = Chasis(
//                        type = Chasis.Type.SEDAN,
//                        seatFactory = Seat.Factory(Seat.Upholstery.LEATHER)
//                    ),
//                    wheelFactory = Wheel.Factory(Wheel.Type.STEEL),
//                    spareWheel = true,
//                ),
//                Engine(
//                    type = Engine.Type.ELECTRIC,
//                    transmission = Transmission(type = Transmission.Type.FWD)
//                )
//            )
//
//            val hondaCity = Vehicle(
//                WheelBase(
//                    size = WheelBase.Size.MEDIUM,
//                    chasis = Chasis(
//                        type = Chasis.Type.SEDAN,
//                        seatFactory = Seat.Factory(Seat.Upholstery.FABRIC)
//                    ),
//                    wheelFactory = Wheel.Factory(Wheel.Type.ALLOY)
//                ),
//                Engine(
//                    type = Engine.Type.DIESEL,
//                    transmission = Transmission(type = Transmission.Type.FWD)
//                )
//            )
//
//            val BMWX7 = Vehicle(
//                WheelBase(
//                    size = WheelBase.Size.LARGE,
//                    chasis = Chasis(
//                        type = Chasis.Type.SUV,
//                        seatFactory = Seat.Factory(Seat.Upholstery.VINYL)
//                    ),
//                    wheelFactory = Wheel.Factory(Wheel.Type.CARBONFIBRE),
//                    spareWheel = true,
//                ),
//                Engine(
//                    type = Engine.Type.HYBRID,
//                    transmission = Transmission(type = Transmission.Type.AWD)
//                )
//            )

            // Using CLI KT library
            println("""
                |------------------Welcome to Car Picker 1.0------------------|
                | Here you may build your own car, with everything fully     |
                | customizable.  Feel free to pick engine, seats, wheels etc.|
                |------------------------------------------------------------|
            """.trimIndent())

            val answer: String? = Terminal().prompt("Do you want to continue? (Y/N)")?.uppercase()
            if (answer != "Y") {
                return
            }

            val wheelbaseSize = when(Terminal().prompt("Enter wheelbase size: [S|M|L]")?.uppercase()) {
                "S" -> WheelBase.Size.SMALL
                "M" -> WheelBase.Size.MEDIUM
                "L" -> WheelBase.Size.LARGE
                else -> throw IllegalArgumentException("Invalid wheelbase size")
            }

            val chasisType = when(Terminal().prompt("Enter chasis type: [SUV|Hatchback|Pickup|Sedan]")?.uppercase()) {
                "SUV" -> Chasis.Type.SUV
                "HATCHBACK" -> Chasis.Type.HATCHBACK
                "PICKUP" -> Chasis.Type.PICKUP
                "SEDAN" -> Chasis.Type.SEDAN
                else -> throw IllegalArgumentException("Invalid chasis type")
            }

            val seatUpholstery = when(Terminal().prompt("Enter seat upholstery: [LEATHER|FABRIC|VINYL]")?.uppercase()) {
                "LEATHER" -> Seat.Upholstery.LEATHER
                "FABRIC" -> Seat.Upholstery.FABRIC
                "VINYL" -> Seat.Upholstery.VINYL
                else -> throw IllegalArgumentException("Invalid seat upholstery")
            }

            val wheelType = when(Terminal().prompt("Enter wheel type: [STEEL|ALLOY|CARBONFIBRE]")?.uppercase()) {
                "STEEL" -> Wheel.Type.STEEL
                "ALLOY" -> Wheel.Type.ALLOY
                "CARBONFIBRE" -> Wheel.Type.CARBONFIBRE
                else -> throw IllegalArgumentException("Invalid wheel type")
            }

            val engineType = when(Terminal().prompt("Enter engine type: [ELECTRIC|HYBRID|DIESEL]")?.uppercase()) {
                "ELECTRIC" -> Engine.Type.ELECTRIC
                "HYBRID" -> Engine.Type.HYBRID
                "DIESEL" -> Engine.Type.DIESEL
                else -> throw IllegalArgumentException("Invalid engine type")
            }

            val transmissionType = when(Terminal().prompt("Enter transmission type: [FWD|RWD|AWD]")?.uppercase()) {
                "FWD" -> Transmission.Type.FWD
                "RWD" -> Transmission.Type.RWD
                "AWD" -> Transmission.Type.AWD
                else -> throw IllegalArgumentException("Invalid transmission type")
            }

            val myCar = Vehicle(
                WheelBase(
                    size = wheelbaseSize,
                    chasis = Chasis(
                        type = chasisType,
                        seatFactory = Seat.Factory(seatUpholstery)
                    ),
                    wheelFactory = Wheel.Factory(wheelType)
                ),
                Engine(
                    type = engineType,
                    transmission = Transmission(type = transmissionType)
                )
            )

            println("The price for my car is: R" + myCar.price)
            println("The Total Wheels that my car has: " + myCar.wheelBase.totalNumberOfWheels)
            println("The number of seats that my car has: " + myCar.wheelBase.chasis.numberOfSeats)
        }
    }
}