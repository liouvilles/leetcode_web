class Solution { fun repeatedNTimes(nums:IntArray):Int{val seen=mutableSetOf<Int>();for(value in nums)if(!seen.add(value))return value;error("invalid input")} }
