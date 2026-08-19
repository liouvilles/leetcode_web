class Solution { fun findValueOfPartition(nums:IntArray):Int{nums.sort();var answer=Int.MAX_VALUE;for(i in 1 until nums.size)answer=minOf(answer,nums[i]-nums[i-1]);return answer} }
