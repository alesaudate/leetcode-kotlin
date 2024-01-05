package addtwonumbers

fun main() {
    val l1 = ListNode(2).also {
        it.next = ListNode(4).also {
            it.next = ListNode(9)
        }
    }

    val l2 = ListNode(5).also {
        it.next = ListNode(6).also {
            it.next = ListNode(4).also {
                it.next = ListNode(9)
            }
        }
    }

    val result = Solution().addTwoNumbers(l1, l2)
    println(result)
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var firstNode: ListNode? = null
        var l1Node = l1
        var l2Node = l2
        var remainder = 0


        while(l1Node != null || l2Node != null) {
            val sum = ((l1Node?.`val` ?: 0) + (l2Node?.`val` ?: 0)) + remainder
            val digit = (sum % 10)
            remainder = sum / 10
            if (result == null) {
                result = ListNode(digit)
                firstNode = result
            } else {
                val newNode = ListNode(digit)
                result.next = newNode
                result = newNode
            }
            l1Node = l1Node?.next
            l2Node = l2Node?.next
        }

        while (remainder != 0) {
            val digit = remainder % 10
            remainder -= digit
            result?.next = ListNode(digit)
            result = result?.next
        }
        return firstNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}