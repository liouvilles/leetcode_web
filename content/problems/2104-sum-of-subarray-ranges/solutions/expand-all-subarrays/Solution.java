class Solution {
    public long subArrayRanges(int[] nums){
        long answer=0;
        for(int left=0;left<nums.length;left++){
            int minimum=nums[left],maximum=nums[left];
            for(int right=left;right<nums.length;right++){
                minimum=Math.min(minimum,nums[right]);
                maximum=Math.max(maximum,nums[right]);
                answer+=maximum-minimum;
            }
        }
        return answer;
    }
}
