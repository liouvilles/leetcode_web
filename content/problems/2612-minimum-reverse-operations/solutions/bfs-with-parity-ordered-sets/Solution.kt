class Solution {
    fun minReverseOperations(n:Int,p:Int,banned:IntArray,k:Int):IntArray{
        val forbidden=BooleanArray(n);
        for(index in banned)forbidden[index]=true;
        val unvisited=Array(2){
            java.util.TreeSet<Int>()
        };
        for(index in 0 until n)if(index!=p&&!forbidden[index])unvisited[index and 1].add(index);
        val distance=IntArray(n){
            -1
        };
        distance[p]=0;
        val queue=java.util.ArrayDeque<Int>();
        queue.add(p);
        while(queue.isNotEmpty()){
            val node=queue.removeFirst();
            val left=maxOf(0,node-k+1);
            val right=minOf(node,n-k);
            val minimum=2*left+k-1-node;
            val maximum=2*right+k-1-node;
            val set=unvisited[minimum and 1];
            var next=set.ceiling(minimum);
            while(next!=null&&next<=maximum){
                val destination=next;
                set.remove(destination);
                distance[destination]=distance[node]+1;
                queue.add(destination);
                next=set.ceiling(minimum)
            }
        };
        return distance
    }
}
