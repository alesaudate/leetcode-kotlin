package reverseinteger

fun main() {
    val x = Solution().reverse(120)
    println(x)
}

class Solution {
    fun reverse(x: Int): Int {
        try {
            val xLine = Math.abs(x)
            var value = xLine.toString().reversed().toInt()
            if (x < 0) {
                value *= -1
            }
            return value
        } catch (e: NumberFormatException) {
            return 0
        }
    }
}