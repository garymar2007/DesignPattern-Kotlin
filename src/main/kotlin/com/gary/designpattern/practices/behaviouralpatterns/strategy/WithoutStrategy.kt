package com.gary.designpattern.practices.behaviouralpatterns.strategy

class Music {
    fun play() {
        println("Playing Music")
    }
}

class Video {
    fun play() {
        println("Playing Video")
    }
}

class Player() {
    fun play(platForm: String) {
        when(platForm) {
            "Music" -> Music().play()
            "Video" -> Video().play()
        }
    }
}

fun main() {
    // context - This does not follow open-close principle because it is difficult to add new functionality.
    val player = Player()
    player.play("Music")
    player.play("Video")

}