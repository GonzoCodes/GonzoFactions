package me.gonzo.faction.storage

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.gonzo.faction.types.players.Player
import java.io.File
import java.io.FileWriter
import java.io.IOException

object Storage {

    fun readPlayer(file: File) {
        val gson = Gson()
        file.listFiles().filter {
            it.extension == "json"
        }.forEach {
            gson.fromJson(it.bufferedReader(), Player::class.java)
        }
    }

    @Throws(IOException::class)
    fun whitePlayer(player : Player) {

        val gson = GsonBuilder().registerTypeAdapter(Player::class.java, PlayerStorage()).setPrettyPrinting().create()

        val writer = FileWriter(player.name + ".json")
        writer.write(gson.toJson(player))
        writer.close()
    }
}
