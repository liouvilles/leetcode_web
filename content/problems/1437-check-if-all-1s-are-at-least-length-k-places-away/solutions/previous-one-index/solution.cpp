class Solution {
    public: bool kLengthApart(vector<int>& nums,int k){
        int previous=0;
        bool found=false;
        for(int i=0;i<(int)nums.size();++i)if(nums[i]){
            if(found&&i-previous<=k)return false;
            previous=i;
            found=true;
        }
        return true;
    }
};
