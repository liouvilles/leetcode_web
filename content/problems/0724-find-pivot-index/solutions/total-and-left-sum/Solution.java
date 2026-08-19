class Solution {
    public int pivotIndex(int[] nums){
        int total=Arrays.stream(nums).sum(),left=0;
        for(int index=0;index<nums.length;index++){
            if(left==total-left-nums[index])return index;
            left+=nums[index];
        }
        return -1;
    }
}
