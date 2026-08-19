class Solution {
    public int maxSubarraySumCircular(int[] nums){
        int total=nums[0],currentMax=nums[0],bestMax=nums[0],currentMin=nums[0],bestMin=nums[0];
        for(int i=1;i<nums.length;i++){
            int value=nums[i];
            currentMax=Math.max(value,currentMax+value);
            bestMax=Math.max(bestMax,currentMax);
            currentMin=Math.min(value,currentMin+value);
            bestMin=Math.min(bestMin,currentMin);
            total+=value;
        }
        return bestMax<0?bestMax:Math.max(bestMax,total-bestMin);
    }
}
