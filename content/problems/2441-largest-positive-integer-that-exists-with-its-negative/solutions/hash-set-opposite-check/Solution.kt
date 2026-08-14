class Solution { fun findMaxK(nums:IntArray):Int{val values=nums.toHashSet();var answer=-1;for(value in nums)if(value>0&&-value in values)answer=maxOf(answer,value);return answer} }
