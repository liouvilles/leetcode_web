class Solution {
    public int longestMonotonicSubarray(int[] nums){
        int increasing=1,decreasing=1,answer=1;
        for(int index=1;index<nums.length;index++){
            if(nums[index]>nums[index-1]){
                increasing++;
                decreasing=1;
            }else if(nums[index]<nums[index-1]){
                decreasing++;
                increasing=1;
            }else increasing=decreasing=1;
            answer=Math.max(answer,Math.max(increasing,decreasing));
        }
        return answer;
    }
}
