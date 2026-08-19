class Solution {
    public int maxNumOfMarkedIndices(int[] nums){
        Arrays.sort(nums);
        int small=0,large=(nums.length+1)/2,pairs=0;
        while(small<nums.length/2&&large<nums.length){
            if(2L*nums[small]<=nums[large]){
                pairs++;
                small++;
            }
            large++;
        }
        return pairs*2;
    }
}
