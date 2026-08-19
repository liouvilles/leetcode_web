class Solution {
    public:long long maxBalancedSubsequenceSum(vector<int>& nums){
        int n=nums.size();
        vector<long long> keys(n),sorted;
        for(int i=0;i<n;++i)keys[i]=(long long)nums[i]-i;
        sorted=keys;
        sort(sorted.begin(),sorted.end());
        sorted.erase(unique(sorted.begin(),sorted.end()),sorted.end());
        vector<long long> tree(sorted.size()+1);
        long long answer=LLONG_MIN;
        for(int i=0;i<n;++i){
            int rank=lower_bound(sorted.begin(),sorted.end(),keys[i])-sorted.begin()+1;
            long long best=0;
            for(int x=rank;x>0;x-=x&-x)best=max(best,tree[x]);
            long long current=nums[i]+best;
            answer=max(answer,current);
            for(int x=rank;x<(int)tree.size();x+=x&-x)tree[x]=max(tree[x],current);
        }
        return answer;
    }
};
