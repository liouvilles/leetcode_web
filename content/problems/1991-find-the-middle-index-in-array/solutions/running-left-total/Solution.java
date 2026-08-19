class Solution {
    public int findMiddleIndex(int[] nums){
        int total=Arrays.stream(nums).sum(),left=0;
        for(int i=0;i<nums.length;i++){
            if(left==total-left-nums[i])return i;
            left+=nums[i];
        }
        return -1;
    }
}
