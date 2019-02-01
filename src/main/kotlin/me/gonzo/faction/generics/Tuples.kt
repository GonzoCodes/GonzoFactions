package me.gonzo.faction.generics

data class Triple<A, B, C>(
    var first: A,
    var second: B,
    var third: C
)

fun <T> Triple<T, T, T>.toList(): List<T> = listOf(first, second, third)

data class Double<A, B>(
    var first: A,
    var second: B
)

fun <T> Double<T, T>.toList(): List<T> = listOf(first, second)