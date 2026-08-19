class Solution {
    fun lastStoneWeight(stones:IntArray):Int{
        val heap=java.util.PriorityQueue<Int>(compareByDescending{
            it
        });
        for(stone in stones)heap.add(stone);
        while(heap.size>1){
            val first=heap.remove();
            val second=heap.remove();
            if(first>second)heap.add(first-second)
        };
        return if(heap.isEmpty())0 else heap.peek()
    }
}
