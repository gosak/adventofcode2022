package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day2Test : FreeSpec({
    "test 2_1" {
        // given
        val input = listOf(
            "A Y",
            "B X",
            "C Z",
        )
        val expectedResult = 15

        // when
        val result = day2_1(input)

        // then
        result `should be equal to` expectedResult
    }

    "test 2_2" {
        // given
        val input = listOf(
            "A Y",
            "B X",
            "C Z",
        )
        val expectedResult = 12

        // when
        val result = day2_2(input)

        // then
        result `should be equal to` expectedResult
    }
})
