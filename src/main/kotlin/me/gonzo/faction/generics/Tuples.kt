package me.gonzo.faction.generics

import java.io.Serializable

data class Triple<A, B, C>(
    var neutral: A,
    var enemy: B,
    var civil: C
) : Serializable {

    override fun toString(): String = "($neutral, $enemy, $civil)"
}

fun <T> Triple<T, T, T>.toList(): List<T> = listOf(neutral, enemy, civil)

data class Pair<A, B>(
    var poder: A,
    var podermax: B
) : Serializable {

    override fun toString(): String = "($poder, $podermax)"
}

fun <T> Pair<T, T>.toList(): List<T> = listOf(poder, podermax)

/*data class Location<A,B,C,D,E,F> (
    var x : A,
    var y : B,
    var z : C,
    var yaw : D,
    var pitch : E,
    var UUID : F
)  : Serializable {

    override fun toString(): String = "($x, $y, $z, $yaw, $pitch, $UUID)"
}

fun <T> Location<T,T,T,T,T,T>.toList() : List<T> = listOf(x, y, z, yaw, pitch, UUID)*/