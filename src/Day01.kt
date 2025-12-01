fun main() {
    fun part1(input: List<String>): Int {
        var position = 50
        var timesZero = 0
        for (string in input) {
            val direction = string.take(1)
            val clicks = string.substringAfter(direction).toInt()
            when (direction) {
                "L" -> {
                    position -= clicks
                    while (position < 0) {
                        position += 100
                    }
                }

                "R" -> {
                    position += clicks
                    while (position > 99) {
                        position -= 100
                    }
                }
            }
            if (position == 0) {
                timesZero += 1
            }
        }

        return timesZero
    }

    fun part2(input: List<String>): Int {
        var position = 50
        var timesZero = 0
        for (string in input) {
            val direction = string.take(1)
            val clicks = string.substringAfter(direction).toInt()
            val previousPosition = position
            when (direction) {
                "L" -> {
                    position -= clicks
                    while (position < 0) {
                        position += 100
                        if (position != 0 && previousPosition != 0) {
                            timesZero += 1
                        }
                    }
                }

                "R" -> {
                    position += clicks
                    while (position > 99) {
                        position -= 100
                        if (position != 0 && previousPosition != 0) {
                            timesZero += 1
                        }
                    }
                }
            }
            if (position == 0) {
                timesZero += 1
            }
        }

        return timesZero
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    check(part1(input) == 997)
    part2(input).println()
}