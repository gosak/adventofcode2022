package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(7)
    println("result ${day7_2(input)}")
}

fun day7_2(input: List<String>): Int {
    val fileSystem = input.getFileSystem()
    val totalDiskSpace = 70000000
    val currentSize = fileSystem.size()
    val requiredSpace = 30000000
    return fileSystem.allDirectories().filter {
        totalDiskSpace - currentSize + it.size() >= requiredSpace
    }.minOf { it.size() }
}
