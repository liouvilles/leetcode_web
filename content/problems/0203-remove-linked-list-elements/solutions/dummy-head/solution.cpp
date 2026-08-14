class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode dummy(0, head); ListNode* previous = &dummy;
        while (previous->next) { if (previous->next->val == val) previous->next = previous->next->next; else previous = previous->next; }
        return dummy.next;
    }
};
