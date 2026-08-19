class Solution {
    fun slidingPuzzle(board:Array<IntArray>):Int{
        val start=board.flatMap{
            it.asIterable()
        }.joinToString("");
        val target="123450";
        val neighbors=arrayOf(intArrayOf(1,3),intArrayOf(0,2,4),intArrayOf(1,5),intArrayOf(0,4),intArrayOf(1,3,5),intArrayOf(2,4));
        val queue=java.util.ArrayDeque<Pair<String,Int>>();
        val visited=mutableSetOf(start);
        queue.addLast(start to 0);
        while(queue.isNotEmpty()){
            val(state,distance)=queue.removeFirst();
            if(state==target)return distance;
            val zero=state.indexOf('0');
            for(next in neighbors[zero]){
                val chars=state.toCharArray();
                val temporary=chars[zero];
                chars[zero]=chars[next];
                chars[next]=temporary;
                val candidate=String(chars);
                if(visited.add(candidate))queue.addLast(candidate to distance+1)
            }
        };
        return -1
    }
}
