package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(4)
    println("result ${day4_2(input)}")
}

fun day4_2(input: List<String>): Int {
    val regex = Regex("([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)")
    return input.map { line ->
        val groups = regex.find(line)!!.groups
        val firstRange = IntRange(groups[1]!!.value.toInt(), groups[2]!!.value.toInt())
        val secondRange = IntRange(groups[3]!!.value.toInt(), groups[4]!!.value.toInt())
        firstRange to secondRange
    }.count { (firstRange, secondRange) ->
        firstRange.overlap(secondRange)
    }
}

private fun IntRange.overlap(intRange: IntRange) =
    last >= intRange.first && first <= intRange.last
