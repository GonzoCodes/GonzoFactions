package me.gonzo.faction

import me.gonzo.faction.types.factions.Faction
import me.gonzo.faction.types.players.Player
import org.bukkit.plugin.java.JavaPlugin

object Main : JavaPlugin() {

    lateinit var GonzoFactionsPL : Main
    lateinit var Players : HashMap<String, Player>
    lateinit var Factions : HashMap<String, Faction>

    override fun onEnable() {
        GonzoFactionsPL = this
        Players = hashMapOf()
        Factions = hashMapOf()
    }

    override fun onDisable() {

    }


}