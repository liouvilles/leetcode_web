class Solution { fun divideArray(nums:IntArray):Boolean{val odd=HashSet<Int>();for(value in nums)if(!odd.add(value))odd.remove(value);return odd.isEmpty()} }
