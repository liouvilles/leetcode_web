class Solution {
    long long countAtMost(vector<int>& nums,int limit){
        vector<int> frequency(100001);
        int left=0,distinct=0;
        long long count=0;
        for(int right=0;right<(int)nums.size();++right){
            if(frequency[nums[right]]++==0)++distinct;
            while(distinct>limit)if(--frequency[nums[left++]]==0)--distinct;
            count+=right-left+1;
        }
        return count;
    }
    public:int medianOfUniquenessArray(vector<int>& nums){
        long long total=1LL*nums.size()*(nums.size()+1)/2,target=(total+1)/2;
        int low=1,high=nums.size();
        while(low<high){
            int middle=(low+high)/2;
            if(countAtMost(nums,middle)>=target)high=middle;
            else low=middle+1;
        }
        return low;
    }
};
