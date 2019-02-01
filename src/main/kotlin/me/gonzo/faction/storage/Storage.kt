package me.gonzo.faction.storage

import com.google.gson.GsonBuilder
import me.gonzo.faction.Main
import me.gonzo.faction.types.players.Player
import java.io.*

object Storage {

    fun readPlayers() {
        val gson = GsonBuilder().registerTypeAdapter(Player::class.java, PlayerStorage()).create()
        val file = File(System.getProperty("user.dir"))

        file.listFiles { file -> file.endsWith(".json") }.forEach {
                jsonFile ->
            val player = gson.fromJson(jsonFile.bufferedReader(), Player::class.java)
            Main.Players[player.name] = player
        }
    }

    @Throws(IOException::class)
    fun writePlayer(player : Player) {

        val gson = GsonBuilder().registerTypeAdapter(Player::class.java, PlayerStorage()).setPrettyPrinting().create()

        val writer = FileWriter(player.name + ".json")
        writer.write(gson.toJson(player))
        writer.close()
    }
}
