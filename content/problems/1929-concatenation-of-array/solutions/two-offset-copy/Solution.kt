class Solution { fun getConcatenation(nums:IntArray):IntArray{val answer=IntArray(nums.size*2);for(i in nums.indices){answer[i]=nums[i];answer[i+nums.size]=nums[i]};return answer} }
