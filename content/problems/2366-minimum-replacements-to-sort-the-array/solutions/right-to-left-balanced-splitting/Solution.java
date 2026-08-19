class Solution {
    public long minimumReplacement(int[] nums){
        long answer=0;
        int limit=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            long parts=(nums[i]+(long)limit-1)/limit;
            answer+=parts-1;
            limit=(int)(nums[i]/parts);
        }
        return answer;
    }
}
