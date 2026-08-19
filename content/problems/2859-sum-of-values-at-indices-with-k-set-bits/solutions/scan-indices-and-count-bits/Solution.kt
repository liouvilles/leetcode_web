class Solution { fun sumIndicesWithKSetBits(nums:List<Int>,k:Int):Int{var answer=0;for(index in nums.indices)if(Integer.bitCount(index)==k)answer+=nums[index];return answer} }
