class Solution {
    public int maxSelectedElements(int[] nums){
        Arrays.sort(nums);
        int[] dp=new int[nums[nums.length-1]+2];
        int answer=0;
        for(int value:nums){
            dp[value+1]=Math.max(dp[value+1],dp[value]+1);
            dp[value]=Math.max(dp[value],dp[value-1]+1);
            answer=Math.max(answer,Math.max(dp[value],dp[value+1]));
        }
        return answer;
    }
}
