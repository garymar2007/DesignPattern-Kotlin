package com.gary.designpattern.practices.structuralpatterns.composite

class Bullet

interface CanCountBullets {
    fun bulletsLeft(): Int
}

interface InfantryUnit: CanCountBullets

class Squad(val sniper: Sniper, val rifleman: Rifleman): CanCountBullets {
    override fun bulletsLeft(): Int {
        return sniper.bulletsLeft() + rifleman.bulletsLeft()
    }
}

class Magazine(initialBullets: Int = 30): CanCountBullets {
    private val bullets = List(initialBullets) { Bullet()}
    override fun bulletsLeft(): Int = bullets.size
}

class Sniper(initialBullets: Int = 50): InfantryUnit {
    private val bullets = List(initialBullets) { Bullet()}
    override fun bulletsLeft(): Int = bullets.size
}

class Rifleman(initialMagazines: Int = 3) : InfantryUnit {
    private val magazine = List<Magazine>(initialMagazines) {
        Magazine(5)
    }
    override fun bulletsLeft(): Int {
        return magazine.sumOf { it.bulletsLeft() }
    }
}

fun main(args: Array<String>) {
    val squad = Squad(Sniper(), Rifleman())
    println(squad.bulletsLeft())
}
