class Solution {
    public boolean canSortArray(int[] nums){
        int previousMax=0;
        for(int left=0;left<nums.length;){
            int count=Integer.bitCount(nums[left]),right=left,currentMin=nums[left],currentMax=nums[left];
            while(right+1<nums.length&&Integer.bitCount(nums[right+1])==count){
                right++;
                currentMin=Math.min(currentMin,nums[right]);
                currentMax=Math.max(currentMax,nums[right]);
            }
            if(previousMax>currentMin)return false;
            previousMax=currentMax;
            left=right+1;
        }
        return true;
    }
}
