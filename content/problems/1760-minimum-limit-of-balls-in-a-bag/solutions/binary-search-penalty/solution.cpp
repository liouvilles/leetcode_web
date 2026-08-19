class Solution {
    public: int minimumSize(vector<int>& nums,int maxOperations){
        int left=1,right=*max_element(nums.begin(),nums.end());
        while(left<right){
            int middle=left+(right-left)/2;
            long long operations=0;
            for(int value:nums)operations+=(value-1)/middle;
            if(operations<=maxOperations)right=middle;
            else left=middle+1;
        }
        return left;
    }
};
