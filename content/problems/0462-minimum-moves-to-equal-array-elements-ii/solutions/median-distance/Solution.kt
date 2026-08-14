class Solution { fun minMoves2(nums:IntArray):Int{nums.sort();val median=nums[nums.size/2];var answer=0L;for(value in nums)answer+=kotlin.math.abs(value.toLong()-median);return answer.toInt()} }
