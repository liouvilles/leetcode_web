class Solution { fun minimumDifference(nums:IntArray,k:Int):Int{nums.sort();var answer=Int.MAX_VALUE;for(right in k-1 until nums.size)answer=minOf(answer,nums[right]-nums[right-k+1]);return answer} }
