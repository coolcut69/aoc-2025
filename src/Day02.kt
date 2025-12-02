data class IdRange(val first: String, val last: String)

fun isRepeatedTwice(s: String): Boolean {
    if (s.length % 2 != 0) return false
    val half = s.length / 2
    return s.take(half) == s.substring(half)
}

fun hasRepeatedSequence(s: String): Boolean {
    for (len in 1..s.length / 2) {
        if (s.length % len == 0) {
            val part = s.take(len)
            if (part.repeat(s.length / len) == s) return true
        }
    }
    return false
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
        val map = input[0].split(",").map {
            val split: List<String> = it.split('-')
            IdRange(split[0], split[1])
        }
        var number = 0L
        for (range in map) {
            for (i in range.first.toLong()..range.last.toLong())
                if (hasRepeatedSequence(i.toString())) {
                    number += i
                }
        }
        return number
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 3)

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    val input = readInput("Day02")
    part1(input).println()
    check(part1(input) == 24747430309L)
    part2(input).println()
    check(part2(input) == 30962646823L)
}