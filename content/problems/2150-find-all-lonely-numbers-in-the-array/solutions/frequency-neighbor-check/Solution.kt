class Solution { fun findLonely(nums:IntArray):List<Int>{val count=nums.toList().groupingBy{it}.eachCount();return nums.filter{count[it]==1&&!count.containsKey(it-1)&&!count.containsKey(it+1)}} }
