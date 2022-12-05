package pl.bizarre

import pl.bizarre.common.loadInput

fun main() {
    val input = loadInput(5)
    println("result ${day5_2(input)}")
}

fun day5_2(input: List<String>): String {
    val piles = input.numberOfPiles()
    val storage = input.take(piles).map { line ->
        line.findCrates(piles)
    }.fold((0 until piles).map { mutableListOf<Char>() }) { acc, value ->
        value.forEachIndexed { index, char ->
            if (char != ' ') {
                acc[index] += char
            }
        }
        acc
    }.map { it.reversed().toMutableList() }
    val orders = input.takeLast(input.size - input.indexOf("") - 1).map { it.toOrder() }

    val executor = Day5OrdersExecutor2(storage)
    orders.forEach {
        executor(it)
    }
    return executor.printLastCrates()
}

private fun List<String>.numberOfPiles() = this[indexOf("") - 1].count { it != ' ' }

private fun String.findCrates(piles: Int) =
    (0 until piles).map {
        this[1 + it * 4]
    }

data class Day5Move2(
    private val cratesToMove: Int,
    private val fromPileIndex: Int,
    private val toPileIndex: Int,
) : Day5Order() {
    override fun invoke(storage: List<MutableList<Char>>) {
        val move = storage[fromPileIndex].takeLast(cratesToMove)
        storage[toPileIndex].addAll(move)
        repeat(cratesToMove) {
            storage[fromPileIndex].removeLast()
        }
    }

    companion object {
        val regex = "move ([0-9]+) from ([0-9]+) to ([0-9]+)".toRegex()
    }
}

class Day5OrdersExecutor2(
    private val storage: List<MutableList<Char>>,
) {
    operator fun invoke(order: Day5Order) {
        order.invoke(storage)
    }

    fun printLastCrates() = storage.fold("") { acc, chars -> acc + chars.last() }
}

private fun String.toOrder() =
    when {
        contains("move") -> {
            val groups = Day5Move.regex.find(this)!!.groups
            Day5Move2(
                cratesToMove = groups[1]!!.value.toInt(),
                fromPileIndex = groups[2]!!.value.toInt() - 1,
                toPileIndex = groups[3]!!.value.toInt() - 1,
            )
        }
        else -> error("Unknown order.")
    }
