class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val visited = HashSet<ListNode>()
        var node = head
        while (node != null) {
            if (!visited.add(node)) return true
            node = node.next
        }
        return false
    }
}
