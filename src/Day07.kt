fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day07_test")
    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    val input = readInput("Day07")
    part1(input).println()
    check(part1(input) == 0)
    part2(input).println()
    check(part2(input) == 0)
}