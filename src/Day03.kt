fun main() {
    fun part1(input: List<String>): Int {

        var total = 0
        for (i in input) {
            //transform i to a list of int
            val list: List<Int> = i.map { it.toString().toInt() }
            val positionsOfMaxNumber = list.indexOf(list.max())

            // max number to the left
            total += getJoltage(positionsOfMaxNumber, list)
        }
        return total
    }

    fun part2(input: List<String>): Long {
        return 3121910778619L
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 357)
    check(part2(testInput) == 3121910778619L)

    val input = readInput("Day03")
    part1(input).println()
    check(part1(input) == 17535)
    part2(input).println()
    check(part2(input) == 3121910778619L)
}

private fun getJoltage(
    positionsOfMaxNumber: Int,
    list: List<Int>
): Int {

    return when (positionsOfMaxNumber) {
        0 -> {
            val maxToRight = list.subList(1, list.size).max().or(0)
            (list[0].toString() + maxToRight.toString()).toInt()
        }

        list.size - 1 -> {
            val maxToLeft = list.subList(0, positionsOfMaxNumber).max().or(0)
            (maxToLeft.toString() + list[positionsOfMaxNumber].toString()).toInt()
        }

        else -> {
            if (positionsOfMaxNumber == 1) {
                val maxToLeft = list[0]
                // max number to the right
                val maxToRight = list.subList(positionsOfMaxNumber + 1, list.size).max().or(0)

                val maxNumberA = (list[positionsOfMaxNumber].toString() + maxToRight.toString()).toInt()
                val maxNumberB = (maxToLeft.toString() + list[positionsOfMaxNumber].toString()).toInt()
                maxOf(maxNumberA, maxNumberB)

            }else {
                val maxToLeft = list.subList(0, positionsOfMaxNumber - 1).max().or(0)
                // max number to the right
                val maxToRight = list.subList(positionsOfMaxNumber + 1, list.size).max().or(0)

                val maxNumberA = (list[positionsOfMaxNumber].toString() + maxToRight.toString()).toInt()
                val maxNumberB = (maxToLeft.toString() + list[positionsOfMaxNumber].toString()).toInt()
                maxOf(maxNumberA, maxNumberB)
            }
        }
    }

}