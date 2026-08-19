class Solution {
    public int[] sortedSquares(int[] nums){
        int[] answer=new int[nums.length];
        int left=0,right=nums.length-1;
        for(int write=nums.length-1;write>=0;write--){
            int value;
            if(Math.abs(nums[left])>Math.abs(nums[right]))value=nums[left++];
            else value=nums[right--];
            answer[write]=value*value;
        }
        return answer;
    }
}
