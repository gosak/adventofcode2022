package pl.bizarre

import io.kotest.core.spec.style.FreeSpec
import org.amshove.kluent.`should be equal to`

class Day7Test : FreeSpec({
    val input = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent().split("\n")

    "test 7_1" - {
        day7_1(input) `should be equal to` 95437
    }

    "test 7_2" - {
        day7_2(input) `should be equal to` 24933642
    }
})
