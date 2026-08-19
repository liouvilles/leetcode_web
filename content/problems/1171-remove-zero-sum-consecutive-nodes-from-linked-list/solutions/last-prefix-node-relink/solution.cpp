class Solution {
    public: ListNode* removeZeroSumSublists(ListNode* head){
        ListNode dummy(0,head);
        unordered_map<int,ListNode*> last;
        int prefix=0;
        for(ListNode* node=&dummy;node;node=node->next){
            prefix+=node->val;
            last[prefix]=node;
        }
        prefix=0;
        for(ListNode* node=&dummy;node;node=node->next){
            prefix+=node->val;
            node->next=last[prefix]->next;
        }
        return dummy.next;
    }
};
