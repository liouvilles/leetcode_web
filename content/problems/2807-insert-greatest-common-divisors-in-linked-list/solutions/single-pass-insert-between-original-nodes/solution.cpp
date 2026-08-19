class Solution {
    public:ListNode* insertGreatestCommonDivisors(ListNode* head){
        for(ListNode* node=head;node&&node->next;node=node->next->next)node->next=new ListNode(gcd(node->val,node->next->val),node->next);
        return head;
    }
};
