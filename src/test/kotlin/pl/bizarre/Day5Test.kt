package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day5Test : FreeSpec({
    val input = listOf(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        " 1   2   3 ",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2",
    )

    "test 5_1" {
        day5_1(input) `should be equal to` "CMZ"
    }

    "test 5_2" {
        day5_2(input) `should be equal to` "MCD"
    }
})
