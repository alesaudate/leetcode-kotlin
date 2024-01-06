package palindromenumber

fun main() {
    println(Solution().isPalindrome(1221))
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        if (x == 0) {
            return true
        }

        val digitCount = x.digitCount()
        var result = 0
        var control = x
        for (i in (digitCount- 1)  downTo 0) {
            val divisor = tenPow(i) // Math.pow(10.0, i.toDouble()).toInt()
            val baseDigit = control / divisor
            val toAdd = baseDigit * tenPow(digitCount - i - 1)
            result += toAdd
            control -= (baseDigit * divisor)
        }

        return x == result
    }

    private fun tenPow(x: Int): Int {
        var result = 1
        for (i in 1..x) {
            result *= 10
        }
        return result
    }

    private fun Int.digitCount(): Int {
        var result = 1
        var control = 9
        while (this > control ) {
            result++
            control = (Math.pow (10.0, result.toDouble()) - 1).toInt()
        }
        return result
    }
}