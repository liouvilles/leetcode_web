class Solution { fun findMiddleIndex(nums:IntArray):Int{val total=nums.sum();var left=0;for(i in nums.indices){if(left==total-left-nums[i])return i;left+=nums[i]};return -1} }
