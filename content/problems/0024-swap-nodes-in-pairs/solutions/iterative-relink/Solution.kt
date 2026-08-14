class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var previous: ListNode? = dummy
        while (previous?.next != null && previous.next?.next != null) {
            val first = previous.next!!
            val second = first.next!!
            first.next = second.next
            second.next = first
            previous.next = second
            previous = first
        }
        return dummy.next
    }
}
