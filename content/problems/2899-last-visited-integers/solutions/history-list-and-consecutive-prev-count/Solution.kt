class Solution {
    fun lastVisitedIntegers(nums:IntArray):List<Int>{
        val history=mutableListOf<Int>();
        val answer=mutableListOf<Int>();
        var counter=0;
        for(value in nums)if(value==-1){
            counter++;
            val index=history.size-counter;
            answer.add(if(index>=0)history[index] else -1)
        }else{
            history.add(value);
            counter=0
        };
        return answer
    }
}
