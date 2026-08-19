class Solution {
    public:long long minimumDifference(vector<int>& nums){
        int n=nums.size()/3,length=nums.size();
        vector<long long> prefix(length),suffix(length);
        priority_queue<int> left;
        long long sum=0;
        for(int i=0;i<2*n;++i){
            left.push(nums[i]);
            sum+=nums[i];
            if((int)left.size()>n){
                sum-=left.top();
                left.pop();
            }
            if((int)left.size()==n)prefix[i]=sum;
        }
        priority_queue<int,vector<int>,greater<int>> right;
        sum=0;
        for(int i=length-1;i>=n;--i){
            right.push(nums[i]);
            sum+=nums[i];
            if((int)right.size()>n){
                sum-=right.top();
                right.pop();
            }
            if((int)right.size()==n)suffix[i]=sum;
        }
        long long answer=LLONG_MAX;
        for(int i=n-1;i<2*n;++i)answer=min(answer,prefix[i]-suffix[i+1]);
        return answer;
    }
};
