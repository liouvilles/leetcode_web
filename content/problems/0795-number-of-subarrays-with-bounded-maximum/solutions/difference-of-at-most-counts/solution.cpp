class Solution {
    int atMost(vector<int>& nums,int bound){
        int result=0,length=0;
        for(int value:nums){
            length=value<=bound?length+1:0;
            result+=length;
        }
        return result;
    }
    public:int numSubarrayBoundedMax(vector<int>& nums,int left,int right){
        return atMost(nums,right)-atMost(nums,left-1);
    }
};
