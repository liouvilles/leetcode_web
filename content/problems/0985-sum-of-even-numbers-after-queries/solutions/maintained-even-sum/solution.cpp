class Solution {
    public: vector<int> sumEvenAfterQueries(vector<int>& nums,vector<vector<int>>& queries){
        int evenSum=0;
        for(int value:nums)if(value%2==0)evenSum+=value;
        vector<int> answer;
        for(auto& query:queries){
            int index=query[1];
            if(nums[index]%2==0)evenSum-=nums[index];
            nums[index]+=query[0];
            if(nums[index]%2==0)evenSum+=nums[index];
            answer.push_back(evenSum);
        }
        return answer;
    }
};
