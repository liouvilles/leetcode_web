class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) return head
        var length = 1; var tail = head; while (tail!!.next != null) { tail = tail.next; length++ }
        tail!!.next = head; var steps = length - k % length - 1; var newTail = head; while (steps-- > 0) newTail = newTail!!.next
        val answer = newTail!!.next; newTail.next = null; return answer
    }
}
