class Solution {
    ListNode* reverse(ListNode* node) { ListNode* previous = nullptr; while (node) { ListNode* next = node->next; node->next = previous; previous = node; node = next; } return previous; }
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head; ListNode* fast = head;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* first = head; ListNode* second = reverse(slow);
        while (second) { if (first->val != second->val) return false; first = first->next; second = second->next; }
        return true;
    }
};
