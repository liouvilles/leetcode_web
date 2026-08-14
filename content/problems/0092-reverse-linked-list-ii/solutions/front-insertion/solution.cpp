class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode dummy(0, head); ListNode* previous = &dummy; for (int position = 1; position < left; ++position) previous = previous->next;
        ListNode* current = previous->next;
        for (int count = 0; count < right - left; ++count) { ListNode* moved = current->next; current->next = moved->next; moved->next = previous->next; previous->next = moved; } return dummy.next;
    }
};
