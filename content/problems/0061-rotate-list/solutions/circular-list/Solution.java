class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1; ListNode tail = head; while (tail.next != null) { tail = tail.next; length++; }
        tail.next = head; int steps = length - k % length - 1; ListNode newTail = head; while (steps-- > 0) newTail = newTail.next;
        ListNode answer = newTail.next; newTail.next = null; return answer;
    }
}
