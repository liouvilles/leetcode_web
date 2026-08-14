class Solution { fun findSubarrays(nums:IntArray):Boolean{val seen=HashSet<Int>();for(i in 1 until nums.size)if(!seen.add(nums[i-1]+nums[i]))return true;return false} }
