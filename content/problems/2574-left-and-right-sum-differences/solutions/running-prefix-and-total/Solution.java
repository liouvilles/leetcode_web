class Solution {
    public int[] leftRigthDifference(int[] nums){
        int total=0;
        for(int value:nums)total+=value;
        int left=0;
        int[] answer=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int right=total-left-nums[i];
            answer[i]=Math.abs(left-right);
            left+=nums[i];
        }
        return answer;
    }
}
