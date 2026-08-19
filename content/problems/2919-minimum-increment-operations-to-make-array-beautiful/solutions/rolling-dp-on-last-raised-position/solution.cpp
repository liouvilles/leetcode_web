class Solution {
    long long cost(int value,int k){
        return max(0LL,1LL*k-value);
    }
    public:long long minIncrementOperations(vector<int>& nums,int k){
        long long first=cost(nums[0],k),second=cost(nums[1],k),third=cost(nums[2],k);
        for(int i=3;i<(int)nums.size();++i){
            long long current=cost(nums[i],k)+min({
                first,second,third
            });
            first=second;
            second=third;
            third=current;
        }
        return min({
            first,second,third
        });
    }
};
