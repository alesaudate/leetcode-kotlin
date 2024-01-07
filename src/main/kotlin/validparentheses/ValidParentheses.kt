package validparentheses

fun main() {
    println(Solution().isValid("([)]"))
}

class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val openClose = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}',
        )

        val closeOpen = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{',
        )

        s.forEach {
            if (openClose.containsKey(it)) {
                stack.add(it)
            } else {
                if (stack.isEmpty() || closeOpen[it] != stack.last()) {
                    return false
                } else {
                    stack.removeLast()
                }
            }
        }
        return stack.isEmpty()
    }
}