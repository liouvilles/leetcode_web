class Solution {
    public int longestAlternatingSubarray(int[] nums,int threshold){
        int current=0,answer=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>threshold)current=0;
            else if(current==0)current=nums[i]%2==0?1:0;
            else if(nums[i]%2!=nums[i-1]%2)current++;
            else current=nums[i]%2==0?1:0;
            answer=Math.max(answer,current);
        }
        return answer;
    }
}
