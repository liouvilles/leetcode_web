class Solution {
    public:int minNumber(vector<int>& nums1,vector<int>& nums2){
        bool present[10]={
        };
        for(int value:nums1)present[value]=true;
        int common=10;
        for(int value:nums2)if(present[value])common=min(common,value);
        if(common<10)return common;
        int first=*min_element(nums1.begin(),nums1.end()),second=*min_element(nums2.begin(),nums2.end());
        return min(first,second)*10+max(first,second);
    }
};
