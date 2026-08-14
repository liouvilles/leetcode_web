class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) length++;
        for (int i = 0; i < length / 2; i++) head = head.next;
        return head;
    }
}
