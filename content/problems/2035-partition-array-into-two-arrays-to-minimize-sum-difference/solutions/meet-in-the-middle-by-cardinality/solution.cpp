class Solution {
    public: int minimumDifference(vector<int>& nums){
        int n=nums.size()/2;
        vector<vector<long long>> left(n+1),right(n+1);
        long long total=accumulate(nums.begin(),nums.end(),0LL);
        for(int mask=0;mask<(1<<n);++mask){
            long long a=0,b=0;
            int count=__builtin_popcount((unsigned)mask);
            for(int bit=0;bit<n;++bit)if(mask&(1<<bit)){
                a+=nums[bit];
                b+=nums[n+bit];
            }
            left[count].push_back(a);
            right[count].push_back(b);
        }
        for(auto& values:right)sort(values.begin(),values.end());
        long long answer=LLONG_MAX;
        for(int count=0;count<=n;++count)for(long long a:left[count]){
            auto& values=right[n-count];
            long long target=total/2-a;
            auto iterator=lower_bound(values.begin(),values.end(),target);
            if(iterator!=values.end())answer=min(answer,llabs(total-2*(a+*iterator)));
            if(iterator!=values.begin()){
                --iterator;
                answer=min(answer,llabs(total-2*(a+*iterator)));
            }
        }
        return answer;
    }
};
