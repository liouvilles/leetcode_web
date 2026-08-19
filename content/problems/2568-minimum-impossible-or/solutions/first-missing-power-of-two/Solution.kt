class Solution { fun minImpossibleOR(nums:IntArray):Int{val values=nums.toHashSet();var candidate=1;while(candidate in values)candidate=candidate shl 1;return candidate} }
