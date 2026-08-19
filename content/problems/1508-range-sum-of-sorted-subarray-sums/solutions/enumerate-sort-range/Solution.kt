class Solution {
    fun rangeSum(nums:IntArray,n:Int,left:Int,right:Int):Int{
        val sums=mutableListOf<Int>();
        for(start in 0 until n){
            var sum=0;
            for(end in start until n){
                sum+=nums[end];
                sums.add(sum)
            }
        };
        sums.sort();
        var answer=0L;
        for(i in left-1 until right)answer+=sums[i];
        return (answer%1_000_000_007L).toInt()
    }
}
