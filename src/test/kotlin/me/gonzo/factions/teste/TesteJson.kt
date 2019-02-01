package me.gonzo.factions.teste

import me.gonzo.faction.storage.Storage
import me.gonzo.faction.types.players.Player

var teste : HashMap<String, Player> = hashMapOf()

fun main() {

    val player = Player("GonzoCodes_", "OsBurros", "ASDSD")
    player.combat.deaths.second = 4
    player.combat.slaughter.second = 80
    player.power.power.first = 1
    player.power.power.first = 10


    Storage.whitePlayer(player)


}
