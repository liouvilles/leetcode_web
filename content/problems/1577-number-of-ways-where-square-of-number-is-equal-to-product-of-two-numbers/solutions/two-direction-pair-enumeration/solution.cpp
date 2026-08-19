class Solution {
    int countWays(vector<int>& singles,vector<int>& pairs){
        int answer=0;
        for(int value:singles){
            long long square=1LL*value*value;
            for(int left=0;left<(int)pairs.size();++left)for(int right=left+1;right<(int)pairs.size();++right)if(1LL*pairs[left]*pairs[right]==square)++answer;
        }
        return answer;
    }
    public:int numTriplets(vector<int>& nums1,vector<int>& nums2){
        return countWays(nums1,nums2)+countWays(nums2,nums1);
    }
};
