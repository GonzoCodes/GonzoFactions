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

data class Double<A, B>(
    var poder: A,
    var podermax: B
) : Serializable {

    override fun toString(): String = "($poder, $podermax)"
}

fun <T> Double<T, T>.toList(): List<T> = listOf(poder, podermax)