class Solution { fun isGood(nums:IntArray):Boolean{nums.sort();for(i in 0 until nums.lastIndex)if(nums[i]!=i+1)return false;return nums.last()==nums.lastIndex} }
