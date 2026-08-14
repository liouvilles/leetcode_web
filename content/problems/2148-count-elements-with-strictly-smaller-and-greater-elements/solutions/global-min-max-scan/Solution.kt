class Solution { fun countElements(nums:IntArray):Int{val minimum=nums.minOrNull()!!;val maximum=nums.maxOrNull()!!;return nums.count{it>minimum&&it<maximum}} }
