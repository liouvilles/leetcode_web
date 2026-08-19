class Solution {
    fun maximumImportance(n:Int,roads:Array<IntArray>):Long{
        val degree=LongArray(n);
        for(road in roads){
            degree[road[0]]++;
            degree[road[1]]++
        };
        degree.sort();
        return degree.indices.sumOf{
            degree[it]*(it+1)
        }
    }
}
