package me.gonzo.faction.types.players

import me.gonzo.faction.generics.Pair
import me.gonzo.faction.generics.Triple

class Player(var name : String,
             var factionName : String,
             var last : String,
             var online : Long)
{

    var combat : Combat = Combat()

    var power : Power = Power()

    var permission = PermissionsMember()

    /*val invites = listOf<String>()

    val kdr : Double
    get() {
        val deaths =  combat.deaths.civil + combat.deaths.enemy + combat.deaths.neutral
        val slaughter = combat.slaughter.civil + combat.slaughter.enemy + combat.slaughter.neutral
        return if (deaths > 0 || slaughter > 0) (deaths / slaughter) else 0.0
    }

    val latter : String
    get() {
        val date = Date(online)
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return format.format(date)
    }

    val faction : Faction?
    get() = Main.Factions[factionName]

    val hasFaction : Boolean
    get() = faction == null

    val role = when {
        !hasFaction -> Role.None
        faction?.leader == name -> Role.Leader
        faction?.captains!!.contains(name) -> Role.Office
        faction?.members!!.contains(name) -> Role.Member
        faction?.recruits!!.contains(name) -> Role.Recruit
        else -> Role.None
    }

    val rolechar = when(role) {
        Role.None -> ""
        Role.Recruit -> "-"
        Role.Member -> "+"
        Role.Office -> "*"
        Role.Leader -> "#"
    }
*/
}

class Combat {

    var deaths: Triple<Double, Double, Double> = Triple(0.0,0.0,0.0)
    var slaughter: Triple<Double, Double, Double> = Triple(0.0,0.0,0.0)

}

class Power {

    var power : Pair<Number, Number> = Pair(0,0)

}