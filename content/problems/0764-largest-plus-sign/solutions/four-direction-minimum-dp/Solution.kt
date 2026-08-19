class Solution {
    fun orderOfLargestPlusSign(n:Int,mines:Array<IntArray>):Int{
        val blocked=Array(n){
            BooleanArray(n)
        };
        for(mine in mines)blocked[mine[0]][mine[1]]=true;
        val dp=Array(n){
            IntArray(n){
                n
            }
        };
        for(r in 0 until n){
            var count=0;
            for(c in 0 until n){
                count=if(blocked[r][c])0 else count+1;
                dp[r][c]=minOf(dp[r][c],count)
            };
            count=0;
            for(c in n-1 downTo 0){
                count=if(blocked[r][c])0 else count+1;
                dp[r][c]=minOf(dp[r][c],count)
            }
        };
        for(c in 0 until n){
            var count=0;
            for(r in 0 until n){
                count=if(blocked[r][c])0 else count+1;
                dp[r][c]=minOf(dp[r][c],count)
            };
            count=0;
            for(r in n-1 downTo 0){
                count=if(blocked[r][c])0 else count+1;
                dp[r][c]=minOf(dp[r][c],count)
            }
        };
        return dp.maxOf{
            it.maxOrNull()?:0
        }
    }
}
