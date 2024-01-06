package stringtointegeratoi

fun main() {
    val result = Solution().myAtoi("   -42")
    println(result)
}

class Solution {
    fun myAtoi(s: String): Int {
        var trimmed = s.trim()
        val multiplier = if (trimmed.startsWith("-")) {
            trimmed = trimmed.substring(1)
            -1
        } else {
            if (trimmed.startsWith("+")) {
                trimmed = trimmed.substring(1)
            }
            1
        }

        val sanitizedBuffer = StringBuilder()

        run labeled@ {
            trimmed.forEach {
                if (!it.isDigit()) {
                    return@labeled
                }
                sanitizedBuffer.append(it)
            }
        }

        return try {
            if (sanitizedBuffer.isEmpty()) {
                0
            }
            else {
                sanitizedBuffer.toString().toInt() * multiplier
            }
        } catch (e: NumberFormatException) {
            return if (multiplier == 1) {
                Int.MAX_VALUE
            } else {
                Int.MIN_VALUE
            }
        }
    }
}