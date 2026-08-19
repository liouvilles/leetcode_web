class Solution {
    public: vector<int> nextLargerNodes(ListNode* head){
        vector<int> values;
        for(ListNode* node=head;node;node=node->next)values.push_back(node->val);
        vector<int> answer(values.size()),stack;
        for(int i=0;i<(int)values.size();++i){
            while(!stack.empty()&&values[stack.back()]<values[i]){
                answer[stack.back()]=values[i];
                stack.pop_back();
            }
            stack.push_back(i);
        }
        return answer;
    }
};
