class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = reverse(slow), first = head;
        while (second != null) { if (first.val != second.val) return false; first = first.next; second = second.next; }
        return true;
    }
    private ListNode reverse(ListNode node) { ListNode previous = null; while (node != null) { ListNode next = node.next; node.next = previous; previous = node; node = next; } return previous; }
}
