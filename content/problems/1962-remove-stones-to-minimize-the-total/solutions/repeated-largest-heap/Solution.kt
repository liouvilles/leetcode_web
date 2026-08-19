class Solution {
    fun minStoneSum(piles:IntArray,kValue:Int):Int{
        val heap=java.util.PriorityQueue<Int>(compareByDescending{
            it
        });
        for(pile in piles)heap.add(pile);
        repeat(kValue){
            val value=heap.remove();
            heap.add(value-value/2)
        };
        return heap.sum()
    }
}
