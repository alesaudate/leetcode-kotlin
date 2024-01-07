package integertoroman

fun main() {
    println(Solution().intToRoman(3999))
}

class Solution {
    fun intToRoman(num: Int): String {
        val builtNumber = StringBuilder()
        var leftFromNum = num

        for (i in Digits.entries.reversed()) {
            val divided = leftFromNum / i.value

            if (divided in 1..3) {
                for (index in 1..divided) {
                    builtNumber.append(i.roman)
                }
                leftFromNum -= divided * i.value
                if (leftFromNum == 0) {
                    return builtNumber.toString()
                }
            }

        }
        return builtNumber.toString()
    }

    enum class Digits(val roman: String, val value: Int) {
        ONE("I", 1),
        FOUR("IV", 4),
        FIVE("V", 5),
        NINE("IX", 9),
        TEN("X", 10),
        FORTY("XL", 40),
        FIFTY("L", 50),
        NINETY("XC", 90),
        HUNDRED("C", 100),
        FOUR_HUNDRED("CD", 400),
        FIVE_HUNDRED("D", 500),
        NINE_HUNDRED("CM", 900),
        THOUSAND("M", 1000),
        ;
    }
}