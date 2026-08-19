class Solution {
    fun numTilePossibilities(tiles:String):Int{
        val count=IntArray(26);
        for(ch in tiles)count[ch-'A']++;
        fun dfs():Int{
            var total=0;
            for(i in 0..25)if(count[i]>0){
                count[i]--;
                total+=1+dfs();
                count[i]++
            };
            return total
        };
        return dfs()
    }
}
