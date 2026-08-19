class Solution {
    private lateinit var balls:IntArray;
    private var half=0;
    private lateinit var choose:Array<DoubleArray>;
    private fun dfs(color:Int,used:Int,distinctFirst:Int,distinctSecond:Int,ways:Double):Double{
        if(used>half)return 0.0;
        if(color==balls.size)return if(used==half&&distinctFirst==distinctSecond)ways else 0.0;
        var answer=0.0;
        for(take in 0..balls[color])answer+=dfs(color+1,used+take,distinctFirst+if(take>0)1 else 0,distinctSecond+if(take<balls[color])1 else 0,ways*choose[balls[color]][take]);
        return answer
    };
    fun getProbability(balls:IntArray):Double{
        this.balls=balls;
        val total=balls.sum();
        half=total/2;
        choose=Array(total+1){
            DoubleArray(total+1)
        };
        for(n in 0..total){
            choose[n][0]=1.0;
            choose[n][n]=1.0;
            for(k in 1 until n)choose[n][k]=choose[n-1][k-1]+choose[n-1][k]
        };
        return dfs(0,0,0,0,1.0)/choose[total][half]
    }
}
