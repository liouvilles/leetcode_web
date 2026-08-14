class Solution { fun smallestRangeI(nums:IntArray,k:Int):Int=maxOf(0,nums.maxOrNull()!!-nums.minOrNull()!!-2*k) }
