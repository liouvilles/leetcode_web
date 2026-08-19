class Solution {
    fun findMaxLength(nums:IntArray):Int{
        val first=hashMapOf(0 to -1);
        var balance=0;
        var best=0;
        for(i in nums.indices){
            balance+=if(nums[i]==1)1 else -1;
            val previous=first[balance];
            if(previous!=null)best=maxOf(best,i-previous)else first[balance]=i
        };
        return best
    }
}
