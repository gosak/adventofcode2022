package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(6)
    println("result ${day6_1(input)}")
}

fun day6_1(input: List<String>): Int =
    input.first().findIndexOfPacketMarker() + 1

fun String.findIndexOfPacketMarker(): Int {
    val list = mutableListOf<Char>()
    forEachIndexed { index, char ->
        list.add(char)

        if (list.toSet().size == 4) {
            return index
        }
        if (list.size == 4) {
            list.removeFirstOrNull()
        }
    }
    return -1
}
