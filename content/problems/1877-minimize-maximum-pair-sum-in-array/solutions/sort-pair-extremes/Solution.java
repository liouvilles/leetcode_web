class Solution {
    public int minPairSum(int[] nums){
        Arrays.sort(nums);
        int answer=0;
        for(int left=0,right=nums.length-1;left<right;left++,right--)answer=Math.max(answer,nums[left]+nums[right]);
        return answer;
    }
}
