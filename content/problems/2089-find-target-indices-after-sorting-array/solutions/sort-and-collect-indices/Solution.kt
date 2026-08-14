class Solution { fun targetIndices(nums:IntArray,target:Int):List<Int>{nums.sort();return nums.indices.filter{nums[it]==target}} }
