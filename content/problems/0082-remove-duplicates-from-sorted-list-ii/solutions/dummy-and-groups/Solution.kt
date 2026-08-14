class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous: ListNode = dummy; var current = head
        while (current != null) { if (current.next != null && current.`val` == current.next!!.`val`) { val value = current.`val`; while (current != null && current.`val` == value) current = current.next; previous.next = current } else { previous = current; current = current.next } }
        return dummy.next
    }
}
