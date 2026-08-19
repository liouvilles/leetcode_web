class Solution {
    fun maximumWhiteTiles(tiles:Array<IntArray>,carpetLen:Int):Int{
        tiles.sortBy{
            it[0]
        };
        var right=0;
        var full=0;
        var answer=0;
        for(left in tiles.indices){
            val end=tiles[left][0]+carpetLen-1;
            while(right<tiles.size&&tiles[right][1]<=end){
                full+=tiles[right][1]-tiles[right][0]+1;
                right++
            };
            var covered=full;
            if(right<tiles.size&&tiles[right][0]<=end)covered+=end-tiles[right][0]+1;
            answer=maxOf(answer,covered);
            if(right>left)full-=tiles[left][1]-tiles[left][0]+1 else right=left+1
        };
        return minOf(answer,carpetLen)
    }
}
