package pl.bizarre

import pl.bizarre.Move.Companion.findMove
import pl.bizarre.common.loadInput
import java.util.regex.Pattern

fun main() {
    val input = loadInput(2)
    println("result ${day2_1(input)}")
}

fun day2_1(input: List<String>): Int {
    val whitespace = Pattern.compile("\\s+")
    return input.sumOf { line ->
        val (opponent, my) = whitespace.split(line).map { findMove(it) }
        matchResult(opponent, my)
    }
}

enum class Move(
    val keys: Collection<String>,
    val score: Int,
) {
    Rock(setOf("A", "X"), 1),
    Paper(setOf("B", "Y"), 2),
    Scissors(setOf("C", "Z"), 3);

    // 0 - draw, 1 - win, -1 - lose
    fun result(opponent: Move): Int =
        when {
            opponent == this -> 0
            opponent == Rock && this == Paper -> 1
            opponent == Rock && this == Scissors -> -1
            opponent == Paper && this == Scissors -> 1
            else -> -opponent.result(this)
        }

    companion object {
        fun findMove(value: String) =
            values().find { value in it.keys } ?: error("Invalid key $value")
    }
}

fun matchResult(opponentMove: Move, myMove: Move) =
    3 + myMove.result(opponentMove) * 3 + myMove.score
