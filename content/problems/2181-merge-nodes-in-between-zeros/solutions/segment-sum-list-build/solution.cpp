class Solution {
    public:ListNode* mergeNodes(ListNode* head){
        ListNode dummy,*tail=&dummy;
        int sum=0;
        for(ListNode* node=head->next;node;node=node->next)if(!node->val){
            tail->next=new ListNode(sum);
            tail=tail->next;
            sum=0;
        }else sum+=node->val;
        return dummy.next;
    }
};
