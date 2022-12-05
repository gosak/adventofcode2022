package pl.bizarre

import pl.bizarre.Day2Move.Companion.findMove
import pl.bizarre.Day2Move.Paper
import pl.bizarre.Day2Move.Rock
import pl.bizarre.Day2Move.Scissors
import pl.bizarre.common.loadInput
import java.util.regex.Pattern

fun main() {
    val input = loadInput(2)
    println("result ${day2_2(input)}")
}

fun day2_2(input: List<String>): Int {
    val whitespace = Pattern.compile("\\s+")
    return input.sumOf { line ->
        val moveToResult = whitespace.split(line)
        val opponentMove = findMove(moveToResult[0])
        val requiredResult = result(moveToResult[1])
        matchResult(opponentMove, moveForResult(opponentMove, requiredResult))
    }
}

fun result(value: String): Int = when (value) {
    "X" -> -1
    "Y" -> 0
    "Z" -> 1
    else -> error("Invalid key $value")
}

fun moveForResult(opponentMove: Day2Move, result: Int): Day2Move =
    when {
        // on nozyczki, to ja musze kamien bo result == 1
        result == 0 -> opponentMove
        opponentMove == Rock -> if (result > 0) Paper else Scissors
        opponentMove == Scissors -> if (result > 0) Rock else Paper
        opponentMove == Paper -> if (result > 0) Scissors else Rock
        else -> error("Impossible")
    }
