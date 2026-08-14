class Solution {
    ListNode* merge(ListNode* first, ListNode* second) { ListNode dummy; ListNode* tail = &dummy; while (first && second) { if (first->val <= second->val) { tail->next = first; first = first->next; } else { tail->next = second; second = second->next; } tail = tail->next; } tail->next = first ? first : second; return dummy.next; }
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* slow = head; ListNode* fast = head->next;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* second = slow->next; slow->next = nullptr;
        return merge(sortList(head), sortList(second));
    }
};
