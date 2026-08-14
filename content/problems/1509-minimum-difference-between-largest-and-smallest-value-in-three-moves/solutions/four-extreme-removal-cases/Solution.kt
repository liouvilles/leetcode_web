class Solution { fun minDifference(nums:IntArray):Int{if(nums.size<=4)return 0;nums.sort();return (0..3).minOf{nums[nums.size-4+it]-nums[it]}} }
