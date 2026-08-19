class Solution {
    public: vector<int> decompressRLElist(vector<int>& nums){
        vector<int> answer;
        for(int i=0;i<(int)nums.size();i+=2)answer.insert(answer.end(),nums[i],nums[i+1]);
        return answer;
    }
};
