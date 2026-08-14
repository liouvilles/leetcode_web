class Solution { fun thirdMax(nums:IntArray):Int{val top=java.util.TreeSet<Int>();for(value in nums){top.add(value);if(top.size>3)top.pollFirst()};return if(top.size==3)top.first() else top.last()} }
