package romantointeger

fun main() {
    println(Solution().romanToInt("MCMXCIV"))
}

class Solution {
    fun romanToInt(s: String): Int {
        var cursor = getDigits(s.first())
        var value = cursor.value
        val charArray = s.toCharArray()

        for (i in 1..<s.length) {
            val foundDigit = getDigits(charArray[i])
            if (cursor.hasSmallerValue(foundDigit)) {
                value -= cursor.value
                value += foundDigit.value - cursor.value
            }
            else {
                value += foundDigit.value
            }
            cursor = foundDigit
        }

        return value
    }

    fun getDigits(value: Char): Digits {
        return Digits.entries.find { it.roman == value }!!
    }

    enum class Digits(val roman: Char, val value: Int) {
        ONE('I', 1),
        FIVE('V', 5),
        TEN('X', 10),
        FIFTY('L', 50),
        HUNDRED('C', 100),
        FIVE_HUNDRED('D', 500),
        THOUSAND('M', 1000),
        ;

        fun hasSmallerValue(other: Digits): Boolean {
            return entries.indexOf(this) < entries.indexOf(other)
        }
    }
}