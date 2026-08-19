class Solution {
    fun largestDivisibleSubset(nums:IntArray):List<Int>{
        nums.sort();
        val length=IntArray(nums.size){
            1
        };
        val previous=IntArray(nums.size){
            -1
        };
        var best=0;
        for(i in nums.indices){
            for(j in 0 until i)if(nums[i]%nums[j]==0&&length[j]+1>length[i]){
                length[i]=length[j]+1;
                previous[i]=j
            };
            if(length[i]>length[best])best=i
        };
        val answer=mutableListOf<Int>();
        var index=best;
        while(index!=-1){
            answer.add(nums[index]);
            index=previous[index]
        };
        answer.reverse();
        return answer
    }
}
