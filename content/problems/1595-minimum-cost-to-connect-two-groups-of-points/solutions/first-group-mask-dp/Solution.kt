class Solution {
    private lateinit var cost:List<List<Int>>;
    private lateinit var minimum:IntArray;
    private lateinit var memo:Array<IntArray>;
    private fun dfs(index:Int,mask:Int):Int{
        if(index==cost.size){
            var answer=0;
            for(j in minimum.indices)if(mask and (1 shl j)==0)answer+=minimum[j];
            return answer
        };
        if(memo[index][mask]!=-1)return memo[index][mask];
        var answer=Int.MAX_VALUE;
        for(j in minimum.indices)answer=minOf(answer,cost[index][j]+dfs(index+1,mask or (1 shl j)));
        memo[index][mask]=answer;
        return answer
    };
    fun connectTwoGroups(cost:List<List<Int>>):Int{
        this.cost=cost;
        val second=cost[0].size;
        minimum=IntArray(second){
            Int.MAX_VALUE
        };
        for(row in cost)for(j in 0 until second)minimum[j]=minOf(minimum[j],row[j]);
        memo=Array(cost.size){
            IntArray(1 shl second){
                -1
            }
        };
        return dfs(0,0)
    }
}
