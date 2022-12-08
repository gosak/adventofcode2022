package pl.bizarre

import pl.bizarre.common.loadInput
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val input = loadInput(8)
    println("result ${day8_2(input)}")
}

fun day8_2(input: List<String>): Int {
    val width = input.first().length
    val height = input.size
    val trees = mutableMapOf<Pair<Int, Int>, Int>()

    // left to right
    for (row in 0 until height) {
        var lastTreeHeight: Int? = null
        var maxHeight: Int? = null
        var maxHeightIndex: Int? = null
        var visibility = 0
        for (column in 0 until width) {
            val position = row to column
            val treeHeight = input[row][column].digitToInt()
            visibility = visibility.visibility(treeHeight, lastTreeHeight)
            var result = if (maxHeight != null && maxHeight < treeHeight) column else visibility
            result = if (maxHeight != null && maxHeight == treeHeight) abs(maxHeightIndex!! - column) else result
            trees.addOrCreate(position, result)
            maxHeight = max(maxHeight ?: 0, treeHeight)
            if (treeHeight == maxHeight) {
                maxHeightIndex = column
            }
            lastTreeHeight = treeHeight
        }
    }

    // right to left
    for (row in 0 until height) {
        var lastTreeHeight: Int? = null
        var maxHeight: Int? = null
        var maxHeightIndex: Int? = null
        var visibility = 0
        for (column in width - 1 downTo 0) {
            val position = row to column
            val treeHeight = input[row][column].digitToInt()
            visibility = visibility.visibility(treeHeight, lastTreeHeight)
            var result = if (maxHeight != null && maxHeight < treeHeight) width - column - 1 else visibility
            result = if (maxHeight != null && maxHeight == treeHeight) abs(maxHeightIndex!! - column) else result
            trees.addOrCreate(position, result)
            maxHeight = max(maxHeight ?: 0, treeHeight)
            if (treeHeight == maxHeight) {
                maxHeightIndex = column
            }
            lastTreeHeight = treeHeight
        }
    }

    // top to bottom
    for (column in 0 until width) {
        var lastTreeHeight: Int? = null
        var maxHeight: Int? = null
        var maxHeightIndex: Int? = null
        var visibility = 0
        for (row in 0 until height) {
            val position = row to column
            val treeHeight = input[row][column].digitToInt()
            visibility = visibility.visibility(treeHeight, lastTreeHeight)
            var result = if (maxHeight != null && maxHeight < treeHeight) row else visibility
            result = if (maxHeight != null && maxHeight >= treeHeight) abs(maxHeightIndex!! - row) else result
            trees.addOrCreate(position, result)
            maxHeight = max(maxHeight ?: 0, treeHeight)
            if (treeHeight == maxHeight) {
                maxHeightIndex = row
            }
            lastTreeHeight = treeHeight
        }
    }

    // bottom to top
    for (column in 0 until width) {
        var lastTreeHeight: Int? = null
        var maxHeight: Int? = null
        var maxHeightIndex: Int? = null
        var visibility = 0
        for (row in height - 1 downTo 0) {
            val position = row to column
            val treeHeight = input[row][column].digitToInt()
            visibility = visibility.visibility(treeHeight, lastTreeHeight)
            var result = if (maxHeight != null && maxHeight < treeHeight) height - row - 1 else visibility
            result = if (maxHeight != null && maxHeight >= treeHeight) abs(maxHeightIndex!! - row) else result
            trees.addOrCreate(position, result)
            maxHeight = max(maxHeight ?: 0, treeHeight)
            if (treeHeight == maxHeight) {
                maxHeightIndex = row
            }
            lastTreeHeight = treeHeight
        }
    }
    val results = trees.map { it.value }
    return trees.map { it.value }.max()
}

fun MutableMap<Pair<Int, Int>, Int>.addOrCreate(key: Pair<Int, Int>, value: Int) {
    this[key] = if (containsKey(key)) get(key)!! * value else value
}

fun Int.visibility(currentTreeHeight: Int, lastTreeHeight: Int?) = when {
    lastTreeHeight == null -> 0
    lastTreeHeight < currentTreeHeight -> this + 1
    else -> 1
}
