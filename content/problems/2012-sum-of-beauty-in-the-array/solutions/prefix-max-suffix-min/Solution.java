class Solution {
    public int sumOfBeauties(int[] nums){
        int n=nums.length;
        int[] left=new int[n],right=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++)left[i]=Math.max(left[i-1],nums[i]);
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)right[i]=Math.min(right[i+1],nums[i]);
        int answer=0;
        for(int i=1;i<n-1;i++)if(nums[i]>left[i-1]&&nums[i]<right[i+1])answer+=2;
        else if(nums[i]>nums[i-1]&&nums[i]<nums[i+1])answer++;
        return answer;
    }
}
