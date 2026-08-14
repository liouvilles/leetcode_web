class Solution { fun minimizeArrayValue(nums:IntArray):Int{var prefix=0L;var answer=0;for(i in nums.indices){prefix+=nums[i];answer=maxOf(answer,((prefix+i)/(i+1)).toInt())};return answer} }
