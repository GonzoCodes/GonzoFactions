package me.gonzo.faction.types.players

import me.gonzo.faction.generics.Double
import me.gonzo.faction.generics.Triple

class Player(var name : String, var faction : String, var last : String, var combat : Combat = Combat(), var power : Power = Power()) {


}

class Combat {

    var deaths: Triple<Int, Int, Int> = Triple(0,0,0)
    var slaughter: Triple<Int, Int, Int> = Triple(0,0,0)

}

class Power {

    var power : me.gonzo.faction.generics.Double<Number, Number> = Double(0,0)

}
