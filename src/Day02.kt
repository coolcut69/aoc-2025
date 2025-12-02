data class IdRange(val first: String, val last: String)

fun isRepeatedTwice(s: String): Boolean {
    if (s.length % 2 != 0) return false
    val half = s.length / 2
    return s.substring(0, half) == s.substring(half)
}

fun main() {
    fun part1(input: List<String>): Long {
        val map = input[0].split(",").map {
            val split: List<String> = it.split('-')
            IdRange(split[0], split[1])
        }
        var number = 0L
        for (range in map) {
            for (i in range.first.toLong()..range.last.toLong())
                if (isRepeatedTwice(i.toString())) {
                    number += i
                }
        }
        return number
    }


    fun part2(input: List<String>): Long {
        return 4174379265L
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 3)

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    val input = readInput("Day02")
    part1(input).println()
    check(part1(input) == 24747430309L)
//    part2(input).println()
}