package com.gary.designpattern.practices.behaviouralpatterns.strategy

interface Platform {
    fun play()
}

class Music1: Platform {
    override fun play() {
        println("Playing Music")
    }
}

class Video1: Platform {
    override fun play() {
        println("Playing Video")
    }
}

class Reels: Platform {
    override fun play() {
        println("Playing Reels")
    }
}

class Player1 {
    fun play(platform: Platform) {
        platform.play()
    }
}

fun main() {
    // now this follows open-close principle: close for modification, and open for extension.
    val player = Player1()
    player.play(Music1())
    player.play(Video1())
    player.play(Reels())
}