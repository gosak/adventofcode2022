package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(3)
    println("result ${day3_1(input)}")
}

fun day3_1(input: List<String>): Int =
    input.map { line ->
        val middle = line.length / 2
        line.subSequence(0, middle).toSet() to line.subSequence(middle, line.length).toSet()
    }.map { (first, second) ->
        first.intersect(second).first()
    }.sumOf(Char::priority)

fun Char.priority(): Int =
    when {
        isLowerCase() -> code - 96
        isUpperCase() -> code - 38
        else -> error("Invalid key")
    }
