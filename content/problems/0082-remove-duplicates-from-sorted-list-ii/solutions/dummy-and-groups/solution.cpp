class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode dummy(0, head); ListNode* previous = &dummy; ListNode* current = head;
        while (current) { if (current->next && current->val == current->next->val) { int value = current->val; while (current && current->val == value) current = current->next; previous->next = current; } else { previous = current; current = current->next; } } return dummy.next;
    }
};
