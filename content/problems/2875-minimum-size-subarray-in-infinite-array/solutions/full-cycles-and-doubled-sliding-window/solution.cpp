class Solution {
    public:int minSizeSubarray(vector<int>& nums,int target){
        int n=nums.size();
        long long total=accumulate(nums.begin(),nums.end(),0LL),quotient=target/total,remainder=target%total;
        if(remainder==0)return quotient*n;
        int left=0,best=INT_MAX;
        long long window=0;
        for(int right=0;right<2*n;++right){
            window+=nums[right%n];
            while(window>remainder&&left<=right)window-=nums[left++%n];
            if(window==remainder)best=min(best,right-left+1);
        }
        return best==INT_MAX?-1:quotient*n+best;
    }
};
