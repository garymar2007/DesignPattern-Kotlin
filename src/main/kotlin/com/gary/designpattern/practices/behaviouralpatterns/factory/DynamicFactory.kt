package com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory

interface Animal {
    val id: Int
    val name: String
}

class Dog(override val id: Int) : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Animal {
    override val name = "Dog"
}

class Cat(override val id: Int) : com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Animal {
    override val name = "Cat"
}

val animalTypes = listOf("dog", "dog", "cat", "dog", "cat", "cat")

class AnimalFactory {
    var counter = 0

    fun createAnimal(animalType: String): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Animal {
        return when(animalType.trim().lowercase()) {
            "dog" -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Dog(
                ++counter
            )
            "cat" -> _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Cat(
                ++counter
            )
            else -> throw IllegalArgumentException("Invalid animal type")
        }
    }
}

val animalTypeBreed = listOf(
    "dog" to "bulldog",
    "dog" to "beagle",
    "dog" to "poodle",
    "cat" to "persian",
    "cat" to "russian blue",
    "cat" to "siamese"
)

// another animal factory
class AnimalFactory2 {
    var counter = 0
    private val dogFactory =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.DogFactory()
    private val catFactory =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.CatFactory()

    fun createAnimal(animalType: String, animalBreed: String): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Animal {
        return when(animalType.trim().lowercase()) {
            "dog" -> dogFactory.createDog(animalBreed, ++counter)
            "cat" -> catFactory.createCat(animalBreed, ++counter)
            else -> throw IllegalArgumentException("Invalid animal type $animalType")
        }
    }

}

class DogFactory {
    fun createDog(breed: String, id: Int): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Dog =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Dog(id)
}

class CatFactory {
    fun createCat(breed: String, id: Int): com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Cat =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.Cat(id)
}

fun main(args: Array<String>) {
    val factory =
        _root_ide_package_.com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory.AnimalFactory()
    for(t in animalTypes) {
        val animal = factory.createAnimal(t)
        println("${animal.id} - ${animal.name}")
    }
}