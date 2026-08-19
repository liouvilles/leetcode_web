class Solution {
    public: string kthLargestNumber(vector<string>& nums,int k){
        sort(nums.begin(),nums.end(),[](const string& a,const string& b){
            return a.size()!=b.size()?a.size()>b.size():a>b;
        });
        return nums[k-1];
    }
};
