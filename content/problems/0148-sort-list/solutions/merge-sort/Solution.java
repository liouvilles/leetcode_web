class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = slow.next; slow.next = null;
        return merge(sortList(head), sortList(second));
    }
    private ListNode merge(ListNode first, ListNode second) { ListNode dummy = new ListNode(), tail = dummy; while (first != null && second != null) { if (first.val <= second.val) { tail.next = first; first = first.next; } else { tail.next = second; second = second.next; } tail = tail.next; } tail.next = first != null ? first : second; return dummy.next; }
}
