package lengthoflastword

fun main() {
    println(Solution().lengthOfLastWord("   fly me   to   the moon  "))
}

class Solution {
    fun lengthOfLastWord(s: String): Int {
        val trimmedString = s.trimEnd()
        if (trimmedString.isEmpty()) {
            return 0
        }
        return trimmedString.substring(trimmedString.lastIndexOf(' ') + 1).length
    }
}