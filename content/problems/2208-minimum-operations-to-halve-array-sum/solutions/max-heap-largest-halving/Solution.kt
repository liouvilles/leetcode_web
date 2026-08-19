class Solution {
    fun halveArray(nums:IntArray):Int{
        val heap=java.util.PriorityQueue<Double>(compareByDescending{
            it
        });
        var total=0.0;
        for(value in nums){
            heap.add(value.toDouble());
            total+=value
        };
        var reduced=0.0;
        var operations=0;
        while(reduced<total/2){
            val half=heap.remove()/2;
            reduced+=half;
            heap.add(half);
            operations++
        };
        return operations
    }
}
