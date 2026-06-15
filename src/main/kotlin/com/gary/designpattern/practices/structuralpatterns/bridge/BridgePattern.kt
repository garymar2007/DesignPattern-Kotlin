package com.gary.designpattern.practices.structuralpatterns.bridge

class BridgePattern {
}

interface Infantry {
    fun move(x: Long, y: Long)

    fun attack(x: Long, y: Long)
}

open class Rifleman: Infantry {
    override fun move(x: Long, y: Long) {
        println("move $x, $y")
    }

    override fun attack(x: Long, y: Long) {
        println("attack $x, $y")
    }
}

class UpgradeRifleman: Rifleman() {
    override fun attack(x: Long, y: Long) {
        super.attack(x, y)
    }
}

class LightRifleman: Rifleman() {
    override fun move(x: Long, y: Long) {
        super.move(x, y)
    }
}

/**
 * All classes in Kotlin are final by default.  The "open" keyword explicitly allows a class to be subclassed.
 */
open class Grenadier: Infantry {
    override fun move(x: Long, y: Long) {
        println("move $x, $y")
    }

    override fun attack(x: Long, y: Long) {
        println("attack $x, $y")
    }
}
class UpgradeGrenadier: Grenadier() {
    override fun attack(x: Long, y: Long) {
        super.attack(x, y)
    }
}
class LightGrenadier: Grenadier() {
    override fun move(x: Long, y: Long) {
        super.move(x, y)
    }
}

/**
 * Problem:
 *  If one more function is needed to be added to the Infantry interface,
 *  then all the 6 classes that implement the interface will need to be updated.
 *
 * The solution: Use the Bridge Pattern.
 */
class Soldier(private val weapon: Weapon, private val legs: Legs) : Infantry {
    override fun move(x: Long, y: Long) {
        println("move $x, $y")
        legs.move()
    }

    override fun attack(x: Long, y: Long) {
        println("attack $x, $y")
        weapon.causeDamage()
    }
}

/**
 * typealias is to define a new name for an existing type, by clearly indicating the intent of the name
 * as well as hiding the actual type.
 */
typealias Meters = Int
typealias PointsOfDamage = Long

interface Weapon {
    fun causeDamage(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

const val GRENADE_DAMAGE = 5L
const val RIFLE_RANGE = 3L
const val REGULAR_SPEED = 1

class Grenade1: Weapon {
    override fun causeDamage(): PointsOfDamage = GRENADE_DAMAGE
}

class GrenadePack: Weapon {
    override fun causeDamage(): PointsOfDamage = GRENADE_DAMAGE * 3
}

class Rifle1: Weapon {
    override fun causeDamage(): PointsOfDamage = RIFLE_RANGE
}

class MachineGun: Weapon {
    override fun causeDamage(): PointsOfDamage = RIFLE_RANGE * 2
}

class RegularLeg: Legs {
    override fun move(): Meters = REGULAR_SPEED
}

class AthleticLegs: Legs {
    override fun move(): Meters = REGULAR_SPEED * 2
}

fun main(args: Array<String>) {
    val rifleman = Soldier(Rifle1(), RegularLeg())
    val grenadier = Soldier(Grenade1(), RegularLeg())
    val upgradedGrenadier = Soldier(GrenadePack(), RegularLeg())
    val upgradedRifleman = Soldier(MachineGun(), RegularLeg())
    val lightRifleman = Soldier(Rifle1(), AthleticLegs())
    val lightGrenadier = Soldier(Grenade1(), AthleticLegs())
}