class Solution { public int findLengthOfLCIS(int[] nums){int current=1,best=1;for(int i=1;i<nums.length;i++){current=nums[i]>nums[i-1]?current+1:1;best=Math.max(best,current);}return best;} }
