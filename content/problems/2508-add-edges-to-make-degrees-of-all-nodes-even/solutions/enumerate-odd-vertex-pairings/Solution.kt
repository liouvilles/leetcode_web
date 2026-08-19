class Solution {
    fun isPossible(n:Int,edges:List<List<Int>>):Boolean{
        val graph=Array(n){
            HashSet<Int>()
        };
        for(edge in edges){
            val a=edge[0]-1;
            val b=edge[1]-1;
            graph[a].add(b);
            graph[b].add(a)
        };
        val odd=(0 until n).filter{
            graph[it].size%2==1
        };
        fun missing(a:Int,b:Int):Boolean{
            return b !in graph[a]
        };
        if(odd.isEmpty())return true;
        if(odd.size==2){
            val a=odd[0];
            val b=odd[1];
            if(missing(a,b))return true;
            return (0 until n).any{
                it!=a&&it!=b&&missing(a,it)&&missing(b,it)
            }
        };
        if(odd.size!=4)return false;
        val (a,b,c,d)=odd;
        return missing(a,b)&&missing(c,d)||missing(a,c)&&missing(b,d)||missing(a,d)&&missing(b,c)
    }
}
