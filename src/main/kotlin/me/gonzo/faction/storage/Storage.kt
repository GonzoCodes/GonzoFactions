package me.gonzo.faction.storage

import com.google.gson.GsonBuilder
import me.gonzo.faction.Main
import me.gonzo.faction.storage.player.PermissionsMemberSerealize
import me.gonzo.faction.storage.player.PlayerStorage
import me.gonzo.faction.types.players.PermissionsMember
import me.gonzo.faction.types.players.Player
import java.io.*

fun readPlayers() {
    val gson = GsonBuilder().registerTypeAdapter(
        Player::class.java,
        PlayerStorage()
    ).registerTypeAdapter(
        PermissionsMember::class.java,
        PermissionsMemberSerealize()
    ).create()
    val file = File(System.getProperty("user.dir"))

    file.listFiles { _,file -> file.endsWith(".json") }.forEach { jsonFile ->
        val player = gson.fromJson(jsonFile.bufferedReader(), Player::class.java)
        Main.Players[player.name] = player
    }
}

@Throws(IOException::class)
fun writePlayer(player : Player) {

    val gson = GsonBuilder().registerTypeAdapter(
        Player::class.java,
        PlayerStorage()
    ).setPrettyPrinting().create()

    val writer = FileWriter(player.name + ".json")
    writer.write(gson.toJson(player))
    writer.close()
}

var Players : HashMap<String, Player> = hashMapOf()