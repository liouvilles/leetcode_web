class Solution {
    public:vector<long long> unmarkedSumArray(vector<int>& nums,vector<vector<int>>& queries){
        int n=nums.size(),pointer=0;
        long long remaining=accumulate(nums.begin(),nums.end(),0LL);
        vector<int> order(n);
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return nums[a]!=nums[b]?nums[a]<nums[b]:a<b;
        });
        vector<char> marked(n);
        vector<long long> answer;
        for(auto& query:queries){
            int index=query[0];
            if(!marked[index]){
                marked[index]=1;
                remaining-=nums[index];
            }
            int need=query[1];
            while(need>0){
                while(pointer<n&&marked[order[pointer]])++pointer;
                if(pointer==n)break;
                int chosen=order[pointer++];
                marked[chosen]=1;
                remaining-=nums[chosen];
                --need;
            }
            answer.push_back(remaining);
        }
        return answer;
    }
};
