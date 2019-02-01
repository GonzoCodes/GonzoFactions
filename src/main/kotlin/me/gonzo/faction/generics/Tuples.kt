package me.gonzo.faction.generics

import java.io.Serializable

data class Triple<A, B, C>(
    var neutro: A,
    var inimigo: B,
    var civis: C
) : Serializable {

    override fun toString(): String = "($neutro, $inimigo, $civis)"
}

fun <T> Triple<T, T, T>.toList(): List<T> = listOf(neutro, inimigo, civis)

data class Double<A, B>(
    var poder: A,
    var podermax: B
) : Serializable {

    override fun toString(): String = "($poder, $podermax)"
}

fun <T> Double<T, T>.toList(): List<T> = listOf(poder, podermax)