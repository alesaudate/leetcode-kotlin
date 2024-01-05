package twosum

fun main() {
    val result = Solution().twoSum(intArrayOf(-1,-2,-3,-4,-5), -8)
    println(result.toList())
}

private class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val mapValues = nums.mapIndexed { index, value -> value to index}.toMap()
        nums.forEachIndexed { index, value ->
            val leftOver = target - value
            if (mapValues.containsKey(leftOver) && mapValues[leftOver] != index) {
                return listOf(index, mapValues[leftOver]!!).toIntArray()
            }
        }
        return emptyArray<Int>().toIntArray()
    }
}