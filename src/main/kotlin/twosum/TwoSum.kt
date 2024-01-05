package twosum

fun main() {
    val result = Solution().twoSum(intArrayOf(1,4,5,3), 6)
    println(result.toList())
}

private class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val mapValues = nums.mapIndexed { index, value -> value to index}.toMap()
        nums.forEachIndexed { index, value ->
            if (value < target) {
                val leftOver = target - value
                if (mapValues.containsKey(leftOver) && mapValues[leftOver] != index) {
                    return listOf(index, mapValues[leftOver]!!).toIntArray()
                }
            }
        }
        return emptyArray<Int>().toIntArray()
    }
}