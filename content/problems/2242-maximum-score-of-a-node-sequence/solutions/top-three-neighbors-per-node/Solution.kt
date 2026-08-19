class Solution {
    fun maximumScore(scores:IntArray,edges:Array<IntArray>):Int{
        val neighbors=Array(scores.size){
            mutableListOf<Int>()
        };
        for(edge in edges){
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0])
        };
        for(list in neighbors)list.sortByDescending{
            scores[it]
        };
        var answer=-1;
        for(edge in edges){
            val b=edge[0];
            val c=edge[1];
            for(a in neighbors[b].take(3))for(d in neighbors[c].take(3))if(a!=c&&d!=b&&a!=d)answer=maxOf(answer,scores[a]+scores[b]+scores[c]+scores[d])
        };
        return answer
    }
}
