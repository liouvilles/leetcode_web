class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var first = l1
        var second = l2
        var carry = 0
        while (first != null || second != null || carry != 0) {
            val sum = carry + (first?.`val` ?: 0) + (second?.`val` ?: 0)
            tail.next = ListNode(sum % 10)
            tail = tail.next!!
            carry = sum / 10
            first = first?.next
            second = second?.next
        }
        return dummy.next
    }
}
