fun main() {
    fun part1(input: List<String>): Int {
        val ranges = input.filter { line -> line.contains('-') }.toList()
        val ingredients = input.subList(ranges.size + 1, input.size).map { it.toLong() }

        var inRange = 0

        for (ingredient in ingredients) {
            for (range in ranges){
                val beginRange = range.split('-')[0].toLong()
                val endRange = range.split('-')[1].toLong()

                if (ingredient in beginRange..endRange) {
                    inRange++
                    break;
                }
            }
        }
        return inRange
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day05_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 0)

    val input = readInput("Day05")
    part1(input).println()
    check(part1(input) == 525)
//    part2(input).println()
//    check(part2(input) == 0)
}