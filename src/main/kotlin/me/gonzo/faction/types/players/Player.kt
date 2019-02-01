package me.gonzo.faction.types.players

import me.gonzo.faction.generics.Double
import me.gonzo.faction.generics.Triple

class Player(var name : String, var faction : String, var last : String, var combat : Combat = Combat(), var power : Power = Power()) {

    val kdr : kotlin.Double
    get() {
        val deaths =  combat.deaths.civil + combat.deaths.enemy + combat.deaths.neutral
        val slaughter = combat.slaughter.civil + combat.slaughter.enemy + combat.slaughter.neutral
        return if (deaths > 0 || slaughter > 0) (deaths / slaughter) else 0.0
    }


}

class Combat {

    var deaths: Triple<kotlin.Double, kotlin.Double, kotlin.Double> = Triple(0.0,0.0,0.0)
    var slaughter: Triple<kotlin.Double, kotlin.Double, kotlin.Double> = Triple(0.0,0.0,0.0)

}

class Power {

    var power : Double<Number, Number> = Double(0,0)

}
