class Solution {
    public:long long minSumSquareDiff(vector<int>& nums1,vector<int>& nums2,int k1,int k2){
        int n=nums1.size(),high=0;
        vector<int> diff(n);
        long long total=0;
        for(int i=0;i<n;++i){
            diff[i]=abs(nums1[i]-nums2[i]);
            high=max(high,diff[i]);
            total+=diff[i];
        }
        long long operations=min(total,(long long)k1+k2);
        int low=0;
        while(low<high){
            int middle=(low+high)/2;
            long long needed=0;
            for(int value:diff)if(value>middle)needed+=value-middle;
            if(needed<=operations)high=middle;
            else low=middle+1;
        }
        int threshold=low;
        long long used=0;
        for(int value:diff)if(value>threshold)used+=value-threshold;
        long long remaining=operations-used,answer=0;
        for(int value:diff){
            int reduced=min(value,threshold);
            if(reduced==threshold&&reduced>0&&remaining){
                --reduced;
                --remaining;
            }
            answer+=1LL*reduced*reduced;
        }
        return answer;
    }
};
