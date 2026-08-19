class Solution {
    fun minIncrements(n:Int,cost:IntArray):Int{
        var answer=0;
        for(node in n/2 downTo 1){
            val left=cost[2*node-1];
            val right=cost[2*node];
            answer+=kotlin.math.abs(left-right);
            cost[node-1]+=maxOf(left,right)
        };
        return answer
    }
}
