class Solution {
    fun numberOfArithmeticSlices(nums:IntArray):Int{
        var current=0;
        var answer=0;
        for(i in 2 until nums.size){
            current=if(nums[i].toLong()-nums[i-1]==nums[i-1].toLong()-nums[i-2])current+1 else 0;
            answer+=current
        };
        return answer
    }
}
