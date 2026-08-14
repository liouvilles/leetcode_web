class Solution { fun minPairSum(nums:IntArray):Int{nums.sort();var answer=0;var left=0;var right=nums.lastIndex;while(left<right)answer=maxOf(answer,nums[left++]+nums[right--]);return answer} }
