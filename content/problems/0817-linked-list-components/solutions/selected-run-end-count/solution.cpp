class Solution {
    public: int numComponents(ListNode* head,vector<int>& nums){
        unordered_set<int> selected(nums.begin(),nums.end());
        int answer=0;
        for(ListNode* node=head;node;node=node->next)if(selected.count(node->val)&&(!node->next||!selected.count(node->next->val)))++answer;
        return answer;
    }
};
