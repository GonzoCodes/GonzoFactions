package me.gonzo.faction

import me.gonzo.faction.types.players.Player
import org.bukkit.plugin.java.JavaPlugin

object Main : JavaPlugin() {

    lateinit var GonzoFactionsPL : Main
    var Players : HashMap<String, Player> = hashMapOf()

    override fun onEnable() {
        GonzoFactionsPL = this
    }

    override fun onDisable() {

    }

}