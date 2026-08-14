class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), previous = dummy;
        while (previous.next != null) { if (previous.next.val == val) previous.next = previous.next.next; else previous = previous.next; }
        return dummy.next;
    }
}
