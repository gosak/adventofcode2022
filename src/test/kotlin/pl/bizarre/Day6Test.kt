package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day6Test : FreeSpec({
    "test 6_1" - {
        listOf(
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
            "nppdvjthqldpwncqszvftbrmjlhg" to 6,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11,
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
        ).forEach { (input, expectedResult) ->
            "should return value" {
                day6_1(listOf(input)) `should be equal to` expectedResult
            }
        }
    }

    "test 6_2" - {
        listOf(
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
            "nppdvjthqldpwncqszvftbrmjlhg" to 23,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26,
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
        ).forEach { (input, expectedResult) ->
            "should return value" {
                day6_2(listOf(input)) `should be equal to` expectedResult
            }
        }
    }
})
