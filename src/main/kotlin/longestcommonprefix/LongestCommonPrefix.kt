package longestcommonprefix

fun main() {
    println(Solution().longestCommonPrefix(listOf("flower","flow","flight").toTypedArray()))
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]

        strs.forEach {
            while (!it.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length - 1)
            }
        }

        return prefix
    }
}