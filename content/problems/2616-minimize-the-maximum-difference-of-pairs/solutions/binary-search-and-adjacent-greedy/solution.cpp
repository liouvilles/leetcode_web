class Solution {
    bool feasible(vector<int>& nums,int p,int limit){
        int pairs=0;
        for(int i=0;i+1<(int)nums.size()&&pairs<p;){
            if(nums[i+1]-nums[i]<=limit){
                ++pairs;
                i+=2;
            }else ++i;
        }
        return pairs>=p;
    }
    public:int minimizeMax(vector<int>& nums,int p){
        sort(nums.begin(),nums.end());
        int left=0,right=nums.back()-nums.front();
        while(left<right){
            int middle=left+(right-left)/2;
            if(feasible(nums,p,middle))right=middle;
            else left=middle+1;
        }
        return left;
    }
};
