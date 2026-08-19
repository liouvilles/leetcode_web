class Solution {
    public:int sumImbalanceNumbers(vector<int>& nums){
        int answer=0,n=nums.size(),maximum=*max_element(nums.begin(),nums.end());
        for(int left=0;left<n;++left){
            vector<bool> seen(maximum+2);
            seen[nums[left]]=true;
            int imbalance=0;
            for(int right=left+1;right<n;++right){
                int value=nums[right];
                if(!seen[value]){
                    ++imbalance;
                    if(seen[value-1])--imbalance;
                    if(seen[value+1])--imbalance;
                    seen[value]=true;
                }
                answer+=imbalance;
            }
        }
        return answer;
    }
};
