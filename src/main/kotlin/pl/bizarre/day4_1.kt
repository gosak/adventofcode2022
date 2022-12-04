package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(4)
    println("result ${day4_1(input)}")
}

fun day4_1(input: List<String>): Int {
    val regex = Regex("([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)")
    return input.map { line ->
        val groups = regex.find(line)!!.groups
        val firstRange = IntRange(groups[1]!!.value.toInt(), groups[2]!!.value.toInt())
        val secondRange = IntRange(groups[3]!!.value.toInt(), groups[4]!!.value.toInt())
        firstRange to secondRange
    }.count { (firstRange, secondRange) ->
        firstRange.contains(secondRange) || secondRange.contains(firstRange)
    }
}

private fun IntRange.contains(intRange: IntRange) =
    first <= intRange.first && last >= intRange.last
