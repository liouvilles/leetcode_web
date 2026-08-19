class Solution {
    public: vector<int> nextGreaterElements(vector<int>& nums){
        int n=nums.size();
        vector<int> answer(n,-1),stack;
        for(int index=0;index<2*n;++index){
            int current=index%n;
            while(!stack.empty()&&nums[stack.back()]<nums[current]){
                answer[stack.back()]=nums[current];
                stack.pop_back();
            }
            if(index<n)stack.push_back(current);
        }
        return answer;
    }
};
