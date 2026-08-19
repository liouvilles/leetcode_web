class Solution {
    public: int tupleSameProduct(vector<int>& nums){
        unordered_map<int,int> frequency;
        int answer=0;
        for(int left=0;left<(int)nums.size();++left)for(int right=left+1;right<(int)nums.size();++right){
            int product=nums[left]*nums[right];
            answer+=8*frequency[product]++;
        }
        return answer;
    }
};
