class Solution {
    public:int pairSum(ListNode* head){
        ListNode *slow=head,*fast=head;
        while(fast){
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* reversed=nullptr;
        while(slow){
            ListNode* next=slow->next;
            slow->next=reversed;
            reversed=slow;
            slow=next;
        }
        int answer=0;
        for(ListNode *first=head,*second=reversed;second;first=first->next,second=second->next)answer=max(answer,first->val+second->val);
        return answer;
    }
};
