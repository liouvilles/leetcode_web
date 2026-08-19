class Solution {
    private lateinit var graph:Array<MutableList<Int>>;
    private lateinit var count:IntArray;
    private lateinit var answer:IntArray;
    private var n=0;
    fun sumOfDistancesInTree(n:Int,edges:Array<IntArray>):IntArray{
        this.n=n;
        graph=Array(n){
            mutableListOf()
        };
        for(edge in edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0])
        };
        count=IntArray(n){
            1
        };
        answer=IntArray(n);
        post(0,-1);
        pre(0,-1);
        return answer
    };
    private fun post(node:Int,parent:Int){
        for(next in graph[node])if(next!=parent){
            post(next,node);
            count[node]+=count[next];
            answer[node]+=answer[next]+count[next]
        }
    };
    private fun pre(node:Int,parent:Int){
        for(next in graph[node])if(next!=parent){
            answer[next]=answer[node]-count[next]+n-count[next];
            pre(next,node)
        }
    }
}
