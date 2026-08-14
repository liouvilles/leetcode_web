class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head; var fast = head.next
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        val second = slow?.next; slow?.next = null
        return merge(sortList(head), sortList(second))
    }
    private fun merge(firstValue: ListNode?, secondValue: ListNode?): ListNode? { val dummy = ListNode(0); var tail = dummy; var first = firstValue; var second = secondValue; while (first != null && second != null) { if (first.`val` <= second.`val`) { tail.next = first; first = first.next } else { tail.next = second; second = second.next }; tail = tail.next!! }; tail.next = first ?: second; return dummy.next }
}
