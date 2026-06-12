package com.gary.designpattern.practices.behaviourpattern.behaviouralpatterns.factory

interface Animal {
    val id: Int
    val name: String
}

class Dog(override val id: Int) : Animal {
    override val name = "Dog"
}

class Cat(override val id: Int) : Animal {
    override val name = "Cat"
}

val animalTypes = listOf("dog", "dog", "cat", "dog", "cat", "cat")

class AnimalFactory {
    var counter = 0

    fun createAnimal(animalType: String): Animal {
        return when(animalType.trim().lowercase()) {
            "dog" -> Dog(++counter)
            "cat" -> Cat(++counter)
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
    private val dogFactory = DogFactory()
    private val catFactory = CatFactory()

    fun createAnimal(animalType: String, animalBreed: String): Animal {
        return when(animalType.trim().lowercase()) {
            "dog" -> dogFactory.createDog(animalBreed, ++counter)
            "cat" -> catFactory.createCat(animalBreed, ++counter)
            else -> throw IllegalArgumentException("Invalid animal type $animalType")
        }
    }

}

class DogFactory {
    fun createDog(breed: String, id: Int): Dog = Dog(id)
}

class CatFactory {
    fun createCat(breed: String, id: Int): Cat = Cat(id)
}

fun main(args: Array<String>) {
    val factory = AnimalFactory()
    for(t in animalTypes) {
        val animal = factory.createAnimal(t)
        println("${animal.id} - ${animal.name}")
    }
}