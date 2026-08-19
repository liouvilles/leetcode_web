class Solution {
    fun minSwap(nums1:IntArray,nums2:IntArray):Int{
        var keep=0;
        var swap=1;
        val infinity=1000000;
        for(i in 1 until nums1.size){
            var nextKeep=infinity;
            var nextSwap=infinity;
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                nextKeep=keep;
                nextSwap=swap+1
            };
            if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                nextKeep=minOf(nextKeep,swap);
                nextSwap=minOf(nextSwap,keep+1)
            };
            keep=nextKeep;
            swap=nextSwap
        };
        return minOf(keep,swap)
    }
}
