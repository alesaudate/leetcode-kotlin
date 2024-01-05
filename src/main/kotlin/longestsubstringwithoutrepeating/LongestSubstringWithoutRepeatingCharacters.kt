package longestsubstringwithoutrepeating


fun main() {
    val input = "dvdf"
    val result = Solution().lengthOfLongestSubstring(input)
    println(result)
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestLength = 0
        var longest = ""

        s.forEach {
            if (longest == "") {
                longest = it.toString()
            } else {
                if (longest.contains(it)) {
                    if (longest.length > longestLength) {
                        longestLength = longest.length
                    }
                    longest = longest.substring(longest.indexOf(it) + 1) + it.toString()
                } else {
                    longest += it
                }
            }
        }

        if (longest.length > longestLength) {
            longestLength = longest.length
        }

        return longestLength
    }
}