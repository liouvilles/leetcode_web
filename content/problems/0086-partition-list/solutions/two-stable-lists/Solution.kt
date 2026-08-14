class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val beforeDummy = ListNode(0); val afterDummy = ListNode(0); var before = beforeDummy; var after = afterDummy; var current = head
        while (current != null) { if (current.`val` < x) { before.next = current; before = current } else { after.next = current; after = current }; current = current.next }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next
    }
}
