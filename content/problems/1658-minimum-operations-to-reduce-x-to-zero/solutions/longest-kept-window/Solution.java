class Solution {
    public int minOperations(int[] nums,int x){
        int target=Arrays.stream(nums).sum()-x;
        if(target<0)return -1;
        if(target==0)return nums.length;
        int left=0,sum=0,longest=-1;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target)sum-=nums[left++];
            if(sum==target)longest=Math.max(longest,right-left+1);
        }
        return longest<0?-1:nums.length-longest;
    }
}
