class Solution {
    public int maxNonDecreasingLength(int[] nums1,int[] nums2){
        int endingFirst=1,endingSecond=1,answer=1;
        for(int i=1;i<nums1.length;i++){
            int nextFirst=1,nextSecond=1;
            if(nums1[i]>=nums1[i-1])nextFirst=Math.max(nextFirst,endingFirst+1);
            if(nums1[i]>=nums2[i-1])nextFirst=Math.max(nextFirst,endingSecond+1);
            if(nums2[i]>=nums1[i-1])nextSecond=Math.max(nextSecond,endingFirst+1);
            if(nums2[i]>=nums2[i-1])nextSecond=Math.max(nextSecond,endingSecond+1);
            endingFirst=nextFirst;
            endingSecond=nextSecond;
            answer=Math.max(answer,Math.max(endingFirst,endingSecond));
        }
        return answer;
    }
}
