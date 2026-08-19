class Solution {
    public int[] rearrangeArray(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i+1<nums.length;i+=2){
            int temporary=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temporary;
        }
        return nums;
    }
}
