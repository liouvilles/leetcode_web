class Solution {
    fun maxPoints(points:Array<IntArray>):Long{
        val cols=points[0].size;
        var dp=LongArray(cols){
            points[0][it].toLong()
        };
        for(row in 1 until points.size){
            val left=LongArray(cols);
            val right=LongArray(cols);
            left[0]=dp[0];
            for(col in 1 until cols)left[col]=maxOf(dp[col],left[col-1]-1);
            right[cols-1]=dp[cols-1];
            for(col in cols-2 downTo 0)right[col]=maxOf(dp[col],right[col+1]-1);
            dp=LongArray(cols){
                points[row][it]+maxOf(left[it],right[it])
            }
        };
        return dp.maxOrNull()!!
    }
}
