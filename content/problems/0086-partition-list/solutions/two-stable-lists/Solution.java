class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0), afterDummy = new ListNode(0), before = beforeDummy, after = afterDummy;
        while (head != null) { if (head.val < x) { before.next = head; before = head; } else { after.next = head; after = head; } head = head.next; }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next;
    }
}
