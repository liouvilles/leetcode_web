class Solution {
    fun findScore(nums:IntArray):Long{
        val order=nums.indices.sortedWith(compareBy<Int>{
            nums[it]
        }.thenBy{
            it
        });
        val marked=BooleanArray(nums.size);
        var score=0L;
        for(index in order)if(!marked[index]){
            score+=nums[index];
            marked[index]=true;
            if(index>0)marked[index-1]=true;
            if(index+1<nums.size)marked[index+1]=true
        };
        return score
    }
}
