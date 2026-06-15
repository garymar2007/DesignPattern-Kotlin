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
        where UnitType : Enum<*>, ProducedUnit : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Unit {
    fun build(type: UnitType): ProducedUnit
}

interface Unit

interface Vehicle: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Unit

interface Infantry: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Unit

class Rifleman: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry

class RocketSoldier: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry

enum class InfantryUnits {
    RIFLEMEN, ROCKET_SOLDIER
}

class Apache : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle

class Tank : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle

class Fighter16 : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle

enum class VehicleUnits {
    APACHE, TANK, F16
}

class Barracks :
    com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry> {
    override fun build(type: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry {
        return when(type) {
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.RIFLEMEN -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Rifleman()
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.ROCKET_SOLDIER -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.RocketSoldier()
        }
    }
}

class VehicleFactory :
    com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle> {
    override fun build(type: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle {
        return when(type) {
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.APACHE -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Apache()
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.TANK -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Tank()
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.F16 -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Fighter16()
        }
    }
}

class HeaderQuarter {
    val buildings = mutableListOf<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<*, *>>()

    fun buildBarracks(): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Barracks {
        val b =
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Barracks()
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
    fun buildBarracks2(): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry> {
        val barracks = object :
            com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry> {
            override fun build(type: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Infantry {
                return when(type) {
                    _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.RIFLEMEN -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Rifleman()
                    _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.ROCKET_SOLDIER -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.RocketSoldier()
                }
            }
        }
        buildings.add(barracks)
        return barracks
    }
    fun buildVehicleFactory2(): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle> {
        val vehicleFactory = object :
            com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Building<com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits, com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Vehicle> {
            override fun build(type: com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits) = when(type) {
                _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.APACHE -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Apache()
                _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.TANK -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Tank()
                _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.F16 -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Fighter16()
            }
        }
        buildings.add(vehicleFactory)
        return vehicleFactory
    }

    fun buildVehicleFactory(): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleFactory {
        val vehicleFactory =
            _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleFactory()
        buildings.add(vehicleFactory)
        return vehicleFactory
    }
}

fun main(args: Array<String>) {
    val headerQuarter =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.HeaderQuarter()
    val barracks1 = headerQuarter.buildBarracks()
    val barracks2 = headerQuarter.buildBarracks()
    val vehicleFactory1 = headerQuarter.buildVehicleFactory()

    val units = listOf(
        barracks1.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.RIFLEMEN),
        barracks2.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.ROCKET_SOLDIER),
        barracks2.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.InfantryUnits.ROCKET_SOLDIER),
        vehicleFactory1.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.TANK),
        vehicleFactory1.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.APACHE),
        vehicleFactory1.build(_root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.VehicleUnits.F16)
    )
}