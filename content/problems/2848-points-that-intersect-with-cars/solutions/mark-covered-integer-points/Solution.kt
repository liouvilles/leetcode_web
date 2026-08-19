class Solution { fun numberOfPoints(nums:List<List<Int>>):Int{val covered=BooleanArray(101);for(interval in nums)for(point in interval[0]..interval[1])covered[point]=true;return covered.count{it}} }
