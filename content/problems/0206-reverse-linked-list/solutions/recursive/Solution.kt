class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val newHead = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return newHead
    }
}
