class Solution {
    fun matrixSum(nums:Array<IntArray>):Int{
        for(row in nums)row.sort();
        var answer=0;
        for(col in nums[0].indices){
            var maximum=0;
            for(row in nums)maximum=maxOf(maximum,row[col]);
            answer+=maximum
        };
        return answer
    }
}
