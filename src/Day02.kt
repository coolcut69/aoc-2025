fun main() {

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 3)

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1)
    check(part2(testInput) == 1)

    val input = readInput("Day02")
    part1(input).println()
    check(part1(input) == 1)
    part2(input).println()
}