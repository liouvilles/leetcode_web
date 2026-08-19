class Solution {
    public:vector<long long> minOperations(vector<int>& nums,vector<int>& queries){
        sort(nums.begin(),nums.end());
        vector<long long> prefix(nums.size()+1),answer;
        for(int i=0;i<(int)nums.size();++i)prefix[i+1]=prefix[i]+nums[i];
        for(int query:queries){
            int index=lower_bound(nums.begin(),nums.end(),query)-nums.begin();
            answer.push_back(1LL*query*index-prefix[index]+prefix[nums.size()]-prefix[index]-1LL*query*(nums.size()-index));
        }
        return answer;
    }
};
