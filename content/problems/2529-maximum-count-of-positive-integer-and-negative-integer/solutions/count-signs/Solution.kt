class Solution { fun maximumCount(nums:IntArray):Int{return maxOf(nums.count{it<0},nums.count{it>0})} }
