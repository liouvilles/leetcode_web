class Solution {
    fun countFairPairs(nums:IntArray,lower:Int,upper:Int):Long{
        nums.sort();
        fun count(limit:Long):Long{
            var result=0L;
            var left=0;
            var right=nums.lastIndex;
            while(left<right){
                if(nums[left].toLong()+nums[right]<=limit){
                    result+=right-left;
                    left++
                }else right--
            };
            return result
        };
        return count(upper.toLong())-count(lower.toLong()-1)
    }
}
