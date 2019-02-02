package me.gonzo.faction.types.factions

import me.gonzo.faction.types.land.Lands
import org.bukkit.Location
import org.bukkit.entity.EntityType

class Faction(
    var name : String,
    var base : Location,
    var lands : List<Lands>,
    var allies : List<String>,
    var enemies : List<String>,
    var leader: String,
    var captains : List<String>,
    var members : List<String>,
    var recruits : List<String>,
    var tag : String
) {

    var protect : List<Lands> = mutableListOf()
    var temporary : List<Lands> = mutableListOf()
    val underattack : List<Lands> = mutableListOf()
    var cachespawners : HashMap<EntityType, Int> = hashMapOf()
    var requests : List<String> = mutableListOf()
    var spawners : HashMap<EntityType, Int> = hashMapOf()
    var historic : HashMap<Long, HashMap<Int, Any>> = hashMapOf()
    val attack : Boolean = false


}
