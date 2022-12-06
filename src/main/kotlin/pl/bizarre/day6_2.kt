package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(6)
    println("result ${day6_2(input)}")
}

fun day6_2(input: List<String>): Int =
    input.first().findIndexOfMessageMarker() + 1

fun String.findIndexOfMessageMarker(): Int {
    val list = mutableListOf<Char>()
    forEachIndexed { index, char ->
        list.add(char)

        if (list.toSet().size == 14) {
            return index
        }
        if (list.size == 14) {
            list.removeFirst()
        }
    }
    return -1
}
