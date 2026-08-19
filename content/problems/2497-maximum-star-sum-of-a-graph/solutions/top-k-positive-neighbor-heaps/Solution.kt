class Solution {
    fun maxStarSum(vals:IntArray,edges:Array<IntArray>,k:Int):Int{
        val heaps=Array(vals.size){
            java.util.PriorityQueue<Int>()
        };
        fun add(node:Int,value:Int){
            if(value<=0||k==0)return;
            heaps[node].offer(value);
            if(heaps[node].size>k)heaps[node].poll()
        };
        for(edge in edges){
            add(edge[0],vals[edge[1]]);
            add(edge[1],vals[edge[0]])
        };
        var answer=Int.MIN_VALUE;
        for(node in vals.indices){
            var sum=vals[node];
            for(value in heaps[node])sum+=value;
            answer=maxOf(answer,sum)
        };
        return answer
    }
}
