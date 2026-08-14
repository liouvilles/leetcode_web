class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous = dummy; for (position in 1 until left) previous = previous.next!!
        val current = previous.next!!
        repeat(right - left) { val moved = current.next!!; current.next = moved.next; moved.next = previous.next; previous.next = moved }
        return dummy.next
    }
}
