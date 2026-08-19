class Solution {
    public int findLength(int[] nums1,int[] nums2){
        int[] dp=new int[nums2.length+1];
        int best=0;
        for(int value:nums1)for(int j=nums2.length;j>=1;j--){
            dp[j]=value==nums2[j-1]?dp[j-1]+1:0;
            best=Math.max(best,dp[j]);
        }
        return best;
    }
}
