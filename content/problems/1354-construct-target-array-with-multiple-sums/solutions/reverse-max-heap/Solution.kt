class Solution {
    fun isPossible(target:IntArray):Boolean{
        val heap=java.util.PriorityQueue<Long>(reverseOrder());
        var total=0L;
        for(value in target){
            heap.add(value.toLong());
            total+=value
        };
        while(true){
            val maximum=heap.remove();
            val rest=total-maximum;
            if(maximum==1L||rest==1L)return true;
            if(rest==0L||rest>=maximum||maximum%rest==0L)return false;
            val previous=maximum%rest;
            total=rest+previous;
            heap.add(previous)
        }
    }
}
