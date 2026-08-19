class Solution {
    public:long long findScore(vector<int>& nums){
        vector<int> order(nums.size());
        iota(order.begin(),order.end(),0);
        sort(order.begin(),order.end(),[&](int a,int b){
            return nums[a]!=nums[b]?nums[a]<nums[b]:a<b;
        });
        vector<bool> marked(nums.size());
        long long score=0;
        for(int index:order)if(!marked[index]){
            score+=nums[index];
            marked[index]=true;
            if(index)marked[index-1]=true;
            if(index+1<(int)nums.size())marked[index+1]=true;
        }
        return score;
    }
};
