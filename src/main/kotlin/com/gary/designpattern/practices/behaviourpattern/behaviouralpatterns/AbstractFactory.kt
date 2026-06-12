package com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory

/**
 *   抽象工厂是工厂的工厂
 */
abstract class AbstractFactory {
}

/**
 *   Kotlin 使用 in、out 和 where 的概念.
 *   被标记为 in 的类型可以用作参数，但不能用作返回值。这也被称为协变(contravariance)。
 *
 *   实际上，这意味着我们可以返回 ProducedUnit 或从它继承的类型，
 *   但不能返回在层次结构中高于 ProducedUnit 的类型。
 *
 *   被标记为 out 的类型只能用作返回值，不能用作参数。这被称为逆变(covariance)。
 *
 *   此外，我们还可以使用 where 关键字对类型引入约束
 */
interface Building<in UnitType, out ProducedUnit>
        where UnitType : Enum<*>, ProducedUnit : Unit {
    fun build(type: UnitType): ProducedUnit
}

interface Unit

interface Vehicle: Unit

interface Infantry: Unit

class Rifleman: Infantry

class RocketSoldier: Infantry

enum class InfantryUnits {
    RIFLEMEN, ROCKET_SOLDIER
}

class Apache : Vehicle

class Tank : Vehicle

class Fighter16 : Vehicle

enum class VehicleUnits {
    APACHE, TANK, F16
}

class Barracks : Building<InfantryUnits, Infantry> {
    override fun build(type: InfantryUnits): Infantry {
        return when(type) {
            InfantryUnits.RIFLEMEN -> Rifleman()
            InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
        }
    }
}

class VehicleFactory : Building<VehicleUnits, Vehicle> {
    override fun build(type: VehicleUnits): Vehicle {
        return when(type) {
            VehicleUnits.APACHE -> Apache()
            VehicleUnits.TANK -> Tank()
            VehicleUnits.F16 -> Fighter16()
        }
    }
}

class HeaderQuarter {
    val buildings = mutableListOf<Building<*, *>>()

    fun buildBarracks(): Barracks {
        val b = Barracks()
        buildings.add(b)
        return b
    }

    /**
     *  Using an object to create anonymous class instance to implement Building interface.
     *
     *  object 关键字的不同用法：
     *  一次是在单例设计模式中，
     *  另一次是在工厂方法设计模式中,
     *  这里是我们使用 object 的第三种方式：用于动态创建匿名类.
     */
    fun buildBarracks2(): Building<InfantryUnits, Infantry> {
        val barracks = object : Building<InfantryUnits, Infantry> {
            override fun build(type: InfantryUnits): Infantry {
                return when(type) {
                    InfantryUnits.RIFLEMEN -> Rifleman()
                    InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
                }
            }
        }
        buildings.add(barracks)
        return barracks
    }
    fun buildVehicleFactory2(): Building<VehicleUnits, Vehicle> {
        val vehicleFactory = object : Building<VehicleUnits, Vehicle> {
            override fun build(type: VehicleUnits) = when(type) {
                VehicleUnits.APACHE -> Apache()
                VehicleUnits.TANK -> Tank()
                VehicleUnits.F16 -> Fighter16()
            }
        }
        buildings.add(vehicleFactory)
        return vehicleFactory
    }

    fun buildVehicleFactory(): VehicleFactory {
        val vehicleFactory = VehicleFactory()
        buildings.add(vehicleFactory)
        return vehicleFactory
    }
}

fun main(args: Array<String>) {
    val headerQuarter = HeaderQuarter()
    val barracks1 = headerQuarter.buildBarracks()
    val barracks2 = headerQuarter.buildBarracks()
    val vehicleFactory1 = headerQuarter.buildVehicleFactory()

    val units = listOf(
        barracks1.build(InfantryUnits.RIFLEMEN),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        vehicleFactory1.build(VehicleUnits.TANK),
        vehicleFactory1.build(VehicleUnits.APACHE),
        vehicleFactory1.build(VehicleUnits.F16)
    )
}