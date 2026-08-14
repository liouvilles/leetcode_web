class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head; var fast = head
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        var first = head; var second = reverse(slow)
        while (second != null) { if (first?.`val` != second.`val`) return false; first = first?.next; second = second.next }
        return true
    }
    private fun reverse(start: ListNode?): ListNode? { var node = start; var previous: ListNode? = null; while (node != null) { val next = node.next; node.next = previous; previous = node; node = next }; return previous }
}
