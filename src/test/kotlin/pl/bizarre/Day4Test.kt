package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day4Test : FreeSpec({
    val input = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8",
    )

    "test 4_1" {
        day4_1(input) `should be equal to` 2
    }

    "test 4_2" {
        day4_2(input) `should be equal to` 4
    }
})
