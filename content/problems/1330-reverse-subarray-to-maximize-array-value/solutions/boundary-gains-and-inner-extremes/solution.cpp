class Solution {
    public: int maxValueAfterReverse(vector<int>& nums){
        int n=nums.size(),base=0,gain=0,maxOfMin=INT_MIN,minOfMax=INT_MAX;
        for(int i=0;i<n-1;++i){
            int a=nums[i],b=nums[i+1],difference=abs(a-b);
            base+=difference;
            gain=max({
                gain,abs(nums[0]-b)-difference,abs(nums[n-1]-a)-difference
            });
            maxOfMin=max(maxOfMin,min(a,b));
            minOfMax=min(minOfMax,max(a,b));
        }
        if(n>1)gain=max(gain,2*(maxOfMin-minOfMax));
        return base+gain;
    }
};
