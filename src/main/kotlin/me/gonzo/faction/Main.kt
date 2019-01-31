package me.gonzo.faction

import me.gonzo.faction.types.players.Player
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.exposed.sql.Database

object Main : JavaPlugin() {

    lateinit var GonzoFactionsPL : Main
    lateinit var Players : HashMap<String, Player>

    override fun onEnable() {
        GonzoFactionsPL = this
        Players = hashMapOf()
    }

    override fun onDisable() {

    }

}