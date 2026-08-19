class Solution {
    public int waysToMakeFair(int[] nums){
        int totalEven=0,totalOdd=0;
        for(int i=0;i<nums.length;i++)if(i%2==0)totalEven+=nums[i];
        else totalOdd+=nums[i];
        int leftEven=0,leftOdd=0,answer=0;
        for(int i=0;i<nums.length;i++){
            int rightEven=totalEven-leftEven-(i%2==0?nums[i]:0);
            int rightOdd=totalOdd-leftOdd-(i%2==1?nums[i]:0);
            if(leftEven+rightOdd==leftOdd+rightEven)answer++;
            if(i%2==0)leftEven+=nums[i];
            else leftOdd+=nums[i];
        }
        return answer;
    }
}
