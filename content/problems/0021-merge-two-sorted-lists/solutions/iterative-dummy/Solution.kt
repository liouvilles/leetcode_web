class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var first = list1
        var second = list2
        val dummy = ListNode(0)
        var tail = dummy
        while (first != null && second != null) {
            if (first.`val` <= second.`val`) {
                tail.next = first
                first = first.next
            } else {
                tail.next = second
                second = second.next
            }
            tail = tail.next!!
        }
        tail.next = first ?: second
        return dummy.next
    }
}
