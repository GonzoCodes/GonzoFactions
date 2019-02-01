package me.gonzo.faction.storage

import com.google.gson.*
import me.gonzo.faction.generics.toList
import me.gonzo.faction.types.players.Player
import java.lang.reflect.Type

class PlayerStorage : JsonSerializer<Player>, JsonDeserializer<Player> {

    override fun serialize(player: Player, type : Type, context: JsonSerializationContext): JsonElement {
        val obj = JsonObject()
        obj.addProperty("name", player.name)
        obj.addProperty("faction", player.faction)
        obj.addProperty("last", player.last)

        val jsoncombat = JsonArray()
        val jsondeaths = JsonArray()
        val jsonprimite = JsonArray()


        for (f in player.combat.slaughter.toList()) {
            val slaughter = JsonPrimitive(f)
            jsoncombat.add(slaughter)
        }

        for (f in player.combat.deaths.toList()) {
            val deaths = JsonPrimitive(f)
            jsondeaths.add(deaths)
        }

        for (f in player.power.power.toList()) {
            val power = JsonPrimitive(f)
            jsonprimite.add(power)
        }

        obj.add("combate", jsoncombat)
        obj.add("combate", jsoncombat)
        obj.add("poder", jsonprimite)


        return obj
    }

    override fun deserialize(player: JsonElement, type: Type, context: JsonDeserializationContext): Player? {
        return null
    }
}