package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(7)
    println("result ${day7_1(input)}")
}

fun day7_1(input: List<String>): Int {
    val fileSystem = input.getFileSystem()
    val allDirectories = fileSystem.allDirectories()
    val allDirectoriesWithSizeAtMost100000 = allDirectories.filter { it.size() <= 100000 }
    return allDirectoriesWithSizeAtMost100000.sumOf { it.size() }
}

fun List<String>.getFileSystem(): Directory {
    val cdRegex = "\\$ cd (.*)".toRegex()
    val fileRegex = "([0-9]+) (.*)".toRegex()
    val dirRegex = "dir (.*)".toRegex()
    val fileSystem = Directory("/")
    var currentDirectory = fileSystem
    forEach { line ->
        when {
            line == "$ cd /" -> {
                currentDirectory = fileSystem
            }
            line == "$ cd .." -> {
                if (currentDirectory.parent != null) {
                    currentDirectory = currentDirectory.parent!!
                }
            }
            cdRegex.matches(line) -> {
                val name = cdRegex.find(line)!!.groups[1]!!.value
                currentDirectory = currentDirectory.files.find { it.name == name } as Directory
            }
            line == "$ ls" -> {}
            fileRegex.matches(line) -> {
                val groups = fileRegex.find(line)!!.groups
                val newFile = SimpleFile(
                    size = groups[1]!!.value.toInt(),
                    name = groups[2]!!.value
                )
                currentDirectory.files.add(newFile)
            }
            dirRegex.matches(line) -> {
                val newFile = Directory(
                    name = dirRegex.find(line)!!.groups[1]!!.value,
                    parent = currentDirectory,
                )
                currentDirectory.files.add(newFile)
            }
        }
    }
    return fileSystem
}

fun File.allDirectories(): List<Directory> =
    when (this) {
        is SimpleFile -> emptyList()
        is Directory -> listOf(this) + files.flatMap { it.allDirectories() }
    }

sealed class File(
    open val name: String,
) {
    abstract fun size(): Int
}

data class SimpleFile(
    override val name: String,
    private val size: Int,
) : File(name) {
    override fun size() = size
}

class Directory(
    override val name: String,
    val files: MutableList<File> = mutableListOf(),
    val parent: Directory? = null,
) : File(name) {
    override fun size() = files.sumOf(File::size)
}
