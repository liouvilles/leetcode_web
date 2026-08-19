class Solution {
    fun findLHS(nums:IntArray):Int{
        val counts=hashMapOf<Int,Int>();
        for(value in nums)counts[value]=(counts[value]?:0)+1;
        var best=0;
        for((value,count) in counts){
            val next=counts[value+1];
            if(next!=null)best=maxOf(best,count+next)
        };
        return best
    }
}
