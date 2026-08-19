class Solution {
    public: vector<int> nodesBetweenCriticalPoints(ListNode* head){
        ListNode* previous=head,*current=head->next;
        int index=1,first=-1,last=-1,minimum=INT_MAX;
        while(current->next){
            if((current->val>previous->val&&current->val>current->next->val)||(current->val<previous->val&&current->val<current->next->val)){
                if(first<0)first=index;
                else minimum=min(minimum,index-last);
                last=index;
            }
            previous=current;
            current=current->next;
            ++index;
        }
        return minimum==INT_MAX?vector<int>{
            -1,-1
        }:vector<int>{
            minimum,last-first
        };
    }
};
