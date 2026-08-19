class Solution {
    public int maximumsSplicedArray(int[] nums1,int[] nums2){
        int sum1=0,sum2=0,current1=0,current2=0,best1=0,best2=0;
        for(int i=0;i<nums1.length;i++){
            sum1+=nums1[i];
            sum2+=nums2[i];
            current1=Math.max(0,current1+nums2[i]-nums1[i]);
            current2=Math.max(0,current2+nums1[i]-nums2[i]);
            best1=Math.max(best1,current1);
            best2=Math.max(best2,current2);
        }
        return Math.max(sum1+best1,sum2+best2);
    }
}
