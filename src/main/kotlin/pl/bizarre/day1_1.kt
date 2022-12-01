package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(1)
    var sum = 0
    var biggest = 0
    input.forEach {
        if (it.isEmpty()) {
            biggest = if (sum > biggest) sum else biggest
            sum = 0
        } else {
            sum += it.toInt()
        }
    }
    println("biggest $biggest")
}
