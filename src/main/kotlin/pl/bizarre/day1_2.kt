package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(1)
    val calories: MutableList<Int> = mutableListOf()
    var sum = 0
    input.forEach {
        if (it.isEmpty()) {
            calories.add(sum)
            sum = 0
        } else {
            sum += it.toInt()
        }
    }
    calories.sort()
    println("biggest three: ${calories.takeLast(3).sum()}")
}
