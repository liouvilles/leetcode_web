class Solution {
    public double findMaxAverage(int[] nums,int k){
        long window=0;
        for(int i=0;i<k;i++)window+=nums[i];
        long best=window;
        for(int right=k;right<nums.length;right++){
            window+=nums[right]-nums[right-k];
            best=Math.max(best,window);
        }
        return(double)best/k;
    }
}
