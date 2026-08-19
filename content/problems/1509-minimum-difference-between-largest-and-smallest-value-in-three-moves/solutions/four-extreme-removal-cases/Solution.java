class Solution {
    public int minDifference(int[] nums){
        if(nums.length<=4)return 0;
        Arrays.sort(nums);
        int answer=Integer.MAX_VALUE,n=nums.length;
        for(int i=0;i<=3;i++)answer=Math.min(answer,nums[n-4+i]-nums[i]);
        return answer;
    }
}
