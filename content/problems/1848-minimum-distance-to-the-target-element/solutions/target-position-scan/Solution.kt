class Solution { fun getMinDistance(nums:IntArray,target:Int,start:Int):Int=nums.indices.filter{nums[it]==target}.minOf{kotlin.math.abs(it-start)} }
