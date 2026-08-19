class Solution {
    public long minSumSquareDiff(int[] nums1,int[] nums2,int k1,int k2){
        int n=nums1.length,high=0;
        int[] diff=new int[n];
        long total=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            high=Math.max(high,diff[i]);
            total+=diff[i];
        }
        long operations=Math.min(total,(long)k1+k2);
        int low=0;
        while(low<high){
            int middle=(low+high)/2;
            long needed=0;
            for(int value:diff)if(value>middle)needed+=value-middle;
            if(needed<=operations)high=middle;
            else low=middle+1;
        }
        int threshold=low;
        long used=0;
        for(int value:diff)if(value>threshold)used+=value-threshold;
        long remaining=operations-used,answer=0;
        for(int value:diff){
            int reduced=Math.min(value,threshold);
            if(reduced==threshold&&reduced>0&&remaining>0){
                reduced--;
                remaining--;
            }
            answer+=(long)reduced*reduced;
        }
        return answer;
    }
}
