class Solution {
    fun smallestTrimmedNumbers(nums:Array<String>,queries:Array<IntArray>):IntArray{
        val length=nums[0].length;
        return IntArray(queries.size){
            q->val k=queries[q][0];
            val trim=queries[q][1];
            val indices=nums.indices.sortedWith(compareBy<Int>{
                nums[it].substring(length-trim)
            }.thenBy{
                it
            });
            indices[k-1]
        }
    }
}
