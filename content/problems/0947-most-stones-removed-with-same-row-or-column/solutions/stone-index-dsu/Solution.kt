class Solution {
    fun removeStones(stones:Array<IntArray>):Int{
        val parent=IntArray(stones.size){
            it
        };
        fun find(xInput:Int):Int{
            var x=xInput;
            while(parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x]
            };
            return x
        };
        fun union(a:Int,b:Int){
            val ra=find(a);
            val rb=find(b);
            if(ra!=rb)parent[ra]=rb
        };
        for(i in stones.indices)for(j in i+1 until stones.size)if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])union(i,j);
        return stones.size-stones.indices.map{
            find(it)
        }.toSet().size
    }
}
