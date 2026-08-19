class Solution {
    public: vector<int> nextGreaterElement(vector<int>& nums1,vector<int>& nums2){
        unordered_map<int,int> next;
        vector<int> stack;
        for(int value:nums2){
            while(!stack.empty()&&stack.back()<value){
                next[stack.back()]=value;
                stack.pop_back();
            }
            stack.push_back(value);
        }
        vector<int> answer;
        for(int value:nums1)answer.push_back(next.count(value)?next[value]:-1);
        return answer;
    }
};
