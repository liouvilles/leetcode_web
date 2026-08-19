class Solution {
    public:vector<int> lexicographicallySmallestArray(vector<int>& nums,int limit){
        int n=nums.size();
        vector<int> order(n),answer(n);
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return nums[a]<nums[b];
        });
        for(int left=0;left<n;){
            int right=left+1;
            while(right<n&&1LL*nums[order[right]]-nums[order[right-1]]<=limit)++right;
            vector<int> positions(order.begin()+left,order.begin()+right);
            sort(positions.begin(),positions.end());
            for(int offset=0;offset<(int)positions.size();++offset)answer[positions[offset]]=nums[order[left+offset]];
            left=right;
        }
        return answer;
    }
};
