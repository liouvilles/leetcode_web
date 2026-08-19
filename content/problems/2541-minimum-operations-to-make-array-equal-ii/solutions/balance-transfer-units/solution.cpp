class Solution {
    public:long long minOperations(vector<int>& nums1,vector<int>& nums2,int k){
        if(!k)return nums1==nums2?0:-1;
        long long positive=0,negative=0;
        for(int i=0;i<(int)nums1.size();++i){
            int difference=nums1[i]-nums2[i];
            if(difference%k)return -1;
            if(difference>0)positive+=difference/k;
            else negative-=difference/k;
        }
        return positive==negative?positive:-1;
    }
};
