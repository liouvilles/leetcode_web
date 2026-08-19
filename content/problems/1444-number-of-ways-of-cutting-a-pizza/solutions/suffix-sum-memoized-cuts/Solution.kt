class Solution {
    private val mod=1_000_000_007;
    private var rows=0;
    private var cols=0;
    private lateinit var apples:Array<IntArray>;
    private lateinit var memo:Array<Array<IntArray>>;
    private fun dfs(row:Int,col:Int,cuts:Int):Int{
        if(apples[row][col]==0)return 0;
        if(cuts==0)return 1;
        if(memo[row][col][cuts]!=-1)return memo[row][col][cuts];
        var answer=0L;
        for(nextRow in row+1 until rows)if(apples[row][col]-apples[nextRow][col]>0)answer+=dfs(nextRow,col,cuts-1);
        for(nextCol in col+1 until cols)if(apples[row][col]-apples[row][nextCol]>0)answer+=dfs(row,nextCol,cuts-1);
        memo[row][col][cuts]=(answer%mod).toInt();
        return memo[row][col][cuts]
    };
    fun ways(pizza:Array<String>,k:Int):Int{
        rows=pizza.size;
        cols=pizza[0].length;
        apples=Array(rows+1){
            IntArray(cols+1)
        };
        for(row in rows-1 downTo 0)for(col in cols-1 downTo 0)apples[row][col]=(if(pizza[row][col]=='A')1 else 0)+apples[row+1][col]+apples[row][col+1]-apples[row+1][col+1];
        memo=Array(rows){
            Array(cols){
                IntArray(k){
                    -1
                }
            }
        };
        return dfs(0,0,k-1)
    }
}
