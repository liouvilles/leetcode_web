class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous: ListNode? = dummy
        while (previous?.next != null) { if (previous.next?.`val` == value) previous.next = previous.next?.next else previous = previous.next }
        return dummy.next
    }
}
