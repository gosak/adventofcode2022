package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(8)
    println("result ${day8_1(input)}")
}

fun day8_1(input: List<String>): Int {
    val width = input.first().length
    val height = input.size
    val visibleTrees = mutableSetOf<Pair<Int, Int>>()

    for (row in 0 until height) {
        var lastLeftHeight: Int? = null
        for (column in 0 until width) {
            val treeHeight = input[row][column].digitToInt()
            val treePosition = row to column
            if (lastLeftHeight == null || lastLeftHeight < treeHeight) {
                lastLeftHeight = treeHeight
                visibleTrees.add(treePosition)
            }
        }
    }

    for (row in 0 until height) {
        var lastRightHeight: Int? = null
        for (column in width - 1 downTo 0) {
            val treeHeight = input[row][column].digitToInt()
            val treePosition = row to column
            if (lastRightHeight == null || lastRightHeight < treeHeight) {
                lastRightHeight = treeHeight
                visibleTrees.add(treePosition)
            }
        }
    }

    for (column in 0 until width) {
        var lastTopHeight: Int? = null
        for (row in 0 until height) {
            val treeHeight = input[row][column].digitToInt()
            val treePosition = row to column
            if (lastTopHeight == null || lastTopHeight < treeHeight) {
                lastTopHeight = treeHeight
                visibleTrees.add(treePosition)
            }
        }
    }

    for (column in width - 1 downTo 0) {
        var lastBottomHeight: Int? = null
        for (row in height - 1 downTo 0) {
            val treeHeight = input[row][column].digitToInt()
            val treePosition = row to column
            if (lastBottomHeight == null || lastBottomHeight < treeHeight) {
                lastBottomHeight = treeHeight
                visibleTrees.add(treePosition)
            }
        }
    }
    return visibleTrees.size
}
