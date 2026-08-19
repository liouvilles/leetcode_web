class Solution {
    private lateinit var floor:String;
    private var length=0;
    private lateinit var memo:Array<IntArray>;
    private fun dfs(index:Int,carpets:Int):Int{
        if(index>=floor.length)return 0;
        if(carpets==0)return floor.substring(index).count{
            it=='1'
        };
        if(memo[index][carpets]>=0)return memo[index][carpets];
        val skip=(floor[index]-'0')+dfs(index+1,carpets);
        val cover=dfs(index+length,carpets-1);
        memo[index][carpets]=minOf(skip,cover);
        return memo[index][carpets]
    };
    fun minimumWhiteTiles(floor:String,numCarpets:Int,carpetLen:Int):Int{
        this.floor=floor;
        length=carpetLen;
        memo=Array(floor.length){
            IntArray(numCarpets+1){
                -1
            }
        };
        return dfs(0,numCarpets)
    }
}
