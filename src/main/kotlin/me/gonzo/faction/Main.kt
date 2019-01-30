package me.gonzo.factions

import me.gonzo.faction.types.Player
import org.bukkit.plugin.java.JavaPlugin

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