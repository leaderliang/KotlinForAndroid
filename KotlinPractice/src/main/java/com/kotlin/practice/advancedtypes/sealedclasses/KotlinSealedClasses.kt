package com.kotlin.practice.advancedtypes.sealedclasses

/**
 * 密封类 sealed class
 *
 * 用 sealed 声明的 class 构造方法是私有的
 *
 *
 */



//region entity
data class Song(val name: String, val url: String, var position: Int)

data class ErrorInfo(val code: Int, val message: String)

object Songs {
    val StarSky = Song("Star Sky", "https://fakeurl.com/321144.mp3", 0)
}
//endregion

//region state
sealed class PlayerState{
    constructor()

    // constructor must be private in sealed class
//    public constructor(a:Int)

    constructor(a:Int)
}

object Idle : PlayerState()
/*{
    val a = 1
}*/

class Playing(val song: Song) : PlayerState() {
    fun start() {}
    fun start(params:String) {}
    fun stop() {}
}

class Error(val errorInfo: ErrorInfo) : PlayerState() {
    fun recover() {}
}
//endregion

class Player {
    var state: PlayerState = Idle

    fun play(song: Song) {
        this.state = when (val state = this.state) {
            Idle -> {
                 Playing(song).also(Playing::start) // 和下面等价
                Playing(song).also{
                    it.start()
//                    it.start("asdfasd")
                }
            }
            is Playing -> {
                state.stop()
                Playing(song).also(Playing::start)
            }
            is Error -> {
                state.recover()
                Playing(song).also(Playing::start)
            }
        }
    }
}

fun main() {
    val player = Player()
    player.play(Songs.StarSky)
}