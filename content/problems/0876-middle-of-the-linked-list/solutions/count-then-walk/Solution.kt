class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var length = 0
        var node = head
        while (node != null) {
            length++
            node = node.next
        }
        node = head
        repeat(length / 2) { node = node?.next }
        return node
    }
}
