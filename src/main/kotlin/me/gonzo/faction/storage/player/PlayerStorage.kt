package me.gonzo.faction.storage.player

import com.google.gson.*
import me.gonzo.faction.generics.toList
import me.gonzo.faction.types.players.PermissionsMember
import me.gonzo.faction.types.players.Player
import java.lang.reflect.Type

class PlayerStorage : JsonSerializer<Player>, JsonDeserializer<Player> {

    override fun serialize(player: Player, type : Type, context: JsonSerializationContext): JsonElement {
        val obj = JsonObject()
        obj.addProperty("name", player.name)
        obj.addProperty("faction", player.factionName)
        obj.addProperty("last", player.last)

        val jsonslaughter  = JsonArray()
        val jsondeaths = JsonArray()
        val jsonprimite = JsonArray()

        val jsonpermission = context.serialize(player.permission)

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

        obj.add("permission", jsonpermission)
        obj.add("slaughter", jsonslaughter)
        obj.add("deaths", jsondeaths)
        obj.add("power", jsonprimite)
        obj.addProperty("online", player.online)



        return obj
    }

    override fun deserialize(player: JsonElement, type: Type, context: JsonDeserializationContext): Player? {
        val json = player.asJsonObject

        val name = json.get("name").asString
        val faction = json.get("faction").asString
        val last = json.get("last").asString
        val online = json.get("online").asLong
        val jsonlaughter = json.get("slaughter").asJsonArray
        val jsondeaths = json.get("deaths").asJsonArray
        val jsonpower = json.get("power").asJsonArray
        val permission = context.deserialize<PermissionsMember>(json.get("permission"), PermissionsMember::class.java)

        val player = Player(name, faction, last, online=online)

        player.permission = permission

        player.combat.slaughter.apply {
            neutral = jsonlaughter[0].asDouble
            enemy = jsonlaughter[1].asDouble
            civil = jsonlaughter[2].asDouble
        }

        player.combat.deaths.apply {
            neutral = jsondeaths[0].asDouble
            enemy = jsondeaths[1].asDouble
            civil = jsondeaths[2].asDouble
        }


        player.power.power.apply {
            poder = jsonpower[0].asDouble
            podermax = jsonpower[1].asDouble
        }

        return player
    }

}

class PermissionsMemberSerealize : JsonSerializer<PermissionsMember>, JsonDeserializer<PermissionsMember> {
    override fun serialize(p: PermissionsMember, type: Type, context: JsonSerializationContext): JsonElement {
        val obj = JsonObject()
        obj.addProperty("build", p.build)
        obj.addProperty("containers", p.containers)
        obj.addProperty("dominate_land", p.dominate_land)
        obj.addProperty("leave_land", p.leave_land)
        obj.addProperty("recruit_members", p.recruit_members)
        obj.addProperty("kick_members", p.kick_members)
        obj.addProperty("redstone", p.redstone)
        obj.addProperty("beacon", p.beacon)
        obj.addProperty("spawners", p.spawners)
        obj.addProperty("base", p.base)
        obj.addProperty("faction_lands", p.faction_lands)
        obj.addProperty("accept_tpa", p.accept_tpa)
        return obj
    }

    override fun deserialize(p: JsonElement, type: Type, context: JsonDeserializationContext): PermissionsMember {
        val json = p.asJsonObject
        val permission = PermissionsMember()
        permission.build = json.get("build").asBoolean
        permission.containers = json.get("containers").asBoolean
        permission.dominate_land = json.get("dominate_land").asBoolean
        permission.leave_land = json.get("leave_land").asBoolean
        permission.recruit_members = json.get("recruit_members").asBoolean
        permission.kick_members = json.get("kick_members").asBoolean
        permission.redstone = json.get("redstone").asBoolean
        permission.beacon = json.get("beacon").asBoolean
        permission.spawners = json.get("spawners").asBoolean
        permission.base = json.get("base").asBoolean
        permission.faction_lands = json.get("faction_lands").asBoolean
        permission.accept_tpa = json.get("accept_tpa").asBoolean
        return permission
    }
}