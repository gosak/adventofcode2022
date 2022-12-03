package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(3)
    println("result ${day3_2(input)}")
}

fun day3_2(input: List<String>): Int =
    input.chunked(3).map { (first, second, third) ->
        Triple(first.toSet(), second.toSet(), third.toSet())
    }.map { (first, second, third) ->
        first.intersect(second).intersect(third).first()
    }.sumOf(Char::priority)
