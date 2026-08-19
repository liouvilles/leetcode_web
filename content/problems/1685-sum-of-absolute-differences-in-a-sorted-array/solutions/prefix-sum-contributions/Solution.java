class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums){
        long total=0;
        for(int value:nums)total+=value;
        long leftSum=0;
        int[] answer=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            long left=(long)nums[i]*i-leftSum;
            long right=total-leftSum-nums[i]-(long)nums[i]*(nums.length-i-1);
            answer[i]=(int)(left+right);
            leftSum+=nums[i];
        }
        return answer;
    }
}
