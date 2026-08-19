class Solution {
    private fun cost(target:Long,n:Int,sum:Long,minimum:Long,cost1:Int,cost2:Int):Long{
        val total=target*n-sum;
        val maxDeficit=target-minimum;
        val pairs=minOf(total/2,total-maxDeficit);
        return pairs*cost2+(total-2*pairs)*cost1
    }
    fun minCostToEqualizeArray(nums:IntArray,cost1:Int,cost2:Int):Int{
        var sum=0L;
        var minimum=Long.MAX_VALUE;
        var maximum=0L;
        for(value in nums){
            sum+=value;
            minimum=minOf(minimum,value.toLong());
            maximum=maxOf(maximum,value.toLong())
        };
        val mod=1000000007L;
        val n=nums.size;
        if(n<=2||2L*cost1<=cost2)return (((maximum*n-sum)*cost1)%mod).toInt();
        val balance=(sum-2*minimum+n-3)/(n-2);
        var best=Long.MAX_VALUE;
        for(delta in 0..3)best=minOf(best,cost(maximum+delta,n,sum,minimum,cost1,cost2));
        for(delta in -3..3){
            val target=balance+delta;
            if(target>=maximum)best=minOf(best,cost(target,n,sum,minimum,cost1,cost2))
        };
        return (best%mod).toInt()
    }
}
