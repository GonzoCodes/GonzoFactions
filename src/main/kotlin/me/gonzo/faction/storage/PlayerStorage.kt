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

        val jsonslaughter  = JsonArray()
        val jsondeaths = JsonArray()
        val jsonprimite = JsonArray()


        for (f in player.combat.slaughter.toList()) {
            val slaughter = JsonPrimitive(f)
            jsonslaughter.add(slaughter)
        }

        for (f in player.combat.deaths.toList()) {
            val deaths = JsonPrimitive(f)
            jsondeaths.add(deaths)
        }

        for (f in player.power.power.toList()) {
            val power = JsonPrimitive(f)
            jsonprimite.add(power)
        }

        obj.add("slaughter", jsonslaughter )
        obj.add("deaths", jsondeaths)
        obj.add("power", jsonprimite)


        return obj
    }

    override fun deserialize(player: JsonElement, type: Type, context: JsonDeserializationContext): Player? {
        val json = player.asJsonObject

        val name = json.get("name").asString
        val faction = json.get("faction").asString
        val last = json.get("last").asString
        val jsonlaughter = json.get("slaughter").asJsonArray
        val jsondeaths = json.get("deaths").asJsonArray
        val jsonpower = json.get("power").asJsonArray

        val player = Player(name, faction, last)
        player.combat.slaughter.apply {
            neutro = jsonlaughter[0].asInt
            inimigo = jsonlaughter[1].asInt
            civis = jsonlaughter[2].asInt
        }

        player.combat.deaths.apply {
            neutro = jsondeaths[0].asInt
            inimigo = jsondeaths[1].asInt
            civis = jsondeaths[2].asInt
        }


        player.power.power.apply {
            poder = jsonpower[0].asDouble
            podermax = jsonpower[1].asDouble
        }

        return player
    }
}