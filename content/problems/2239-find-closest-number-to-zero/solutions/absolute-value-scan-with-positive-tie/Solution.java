class Solution {
    public int findClosestNumber(int[] nums){
        int answer=nums[0];
        for(int value:nums)if(Math.abs(value)<Math.abs(answer)||Math.abs(value)==Math.abs(answer)&&value>answer)answer=value;
        return answer;
    }
}
