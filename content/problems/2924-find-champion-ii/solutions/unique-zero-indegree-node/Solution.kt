class Solution {
    fun findChampion(n:Int,edges:Array<IntArray>):Int{
        val defeated=BooleanArray(n);
        for(edge in edges)defeated[edge[1]]=true;
        var candidate=-1;
        for(team in 0 until n)if(!defeated[team]){
            if(candidate!=-1)return -1;
            candidate=team
        };
        return candidate
    }
}
