package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day8Test : FreeSpec({
    val input = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent().split("\n")

    "test 8_1" - {
        day8_1(input) `should be equal to` 21
    }

    "test 8_2" - {
        day8_2(input) `should be equal to` 8
    }
})
