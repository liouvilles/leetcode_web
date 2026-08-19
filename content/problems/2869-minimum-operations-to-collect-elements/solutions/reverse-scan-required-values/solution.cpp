class Solution {
    public:int minOperations(vector<int>& nums,int k){
        vector<bool> collected(k+1);
        int missing=k;
        for(int i=nums.size()-1;i>=0;--i){
            int value=nums[i];
            if(value<=k&&!collected[value]){
                collected[value]=true;
                --missing;
            }
            if(!missing)return nums.size()-i;
        }
        return nums.size();
    }
};
