class Solution { fun minMoves(nums:IntArray):Int{var sum=0L;var minimum=Int.MAX_VALUE;for(value in nums){sum+=value;minimum=minOf(minimum,value)};return(sum-minimum.toLong()*nums.size).toInt()} }
