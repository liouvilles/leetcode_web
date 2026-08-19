class Solution {
    public int maxRotateFunction(int[] nums){
        long sum=0,current=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            current+=(long)i*nums[i];
        }
        long best=current;
        for(int k=1;k<nums.length;k++){
            current+=sum-(long)nums.length*nums[nums.length-k];
            best=Math.max(best,current);
        }
        return(int)best;
    }
}
