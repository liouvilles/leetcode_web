class Solution {
public:
    bool hasCycle(ListNode* head) {
        unordered_set<ListNode*> visited;
        while (head) {
            if (!visited.insert(head).second) return true;
            head = head->next;
        }
        return false;
    }
};
