class Solution {
    public: int bestRotation(vector<int>& nums){
        int n=nums.size();
        vector<int> change(n);
        for(int i=0;i<n;++i)--change[(i-nums[i]+1+n)%n];
        int best=0;
        for(int k=1;k<n;++k){
            change[k]+=change[k-1]+1;
            if(change[k]>change[best])best=k;
        }
        return best;
    }
};
