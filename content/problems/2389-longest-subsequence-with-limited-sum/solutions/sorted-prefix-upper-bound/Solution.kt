class Solution {
    fun answerQueries(nums:IntArray,queries:IntArray):IntArray{
        nums.sort();
        val prefix=IntArray(nums.size+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        return IntArray(queries.size){
            q->var left=0;
            var right=prefix.size;
            while(left<right){
                val middle=(left+right)/2;
                if(prefix[middle]<=queries[q])left=middle+1 else right=middle
            };
            left-1
        }
    }
}
