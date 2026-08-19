class Solution {
    public: int maxRotateFunction(vector<int>& nums){
        long long sum=0,current=0;
        for(int i=0;i<(int)nums.size();++i){
            sum+=nums[i];
            current+=1LL*i*nums[i];
        }
        long long best=current;
        for(int k=1;k<(int)nums.size();++k){
            current+=sum-1LL*nums.size()*nums[nums.size()-k];
            best=max(best,current);
        }
        return best;
    }
};
