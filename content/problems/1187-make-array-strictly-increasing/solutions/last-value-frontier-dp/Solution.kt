class Solution {
    fun makeArrayIncreasing(arr1:IntArray,arr2:IntArray):Int{
        arr2.sort();
        var states:Map<Int,Int> = mapOf(-1 to 0);
        for(value in arr1){
            val next=java.util.TreeMap<Int,Int>();
            for((last,operations) in states){
                if(value>last)next[value]=minOf(next[value]?:Int.MAX_VALUE,operations);
                val index=upperBound(arr2,last);
                if(index<arr2.size)next[arr2[index]]=minOf(next[arr2[index]]?:Int.MAX_VALUE,operations+1)
            };
            val pruned=mutableMapOf<Int,Int>();
            var best=Int.MAX_VALUE;
            for((last,operations) in next)if(operations<best){
                best=operations;
                pruned[last]=operations
            };
            states=pruned;
            if(states.isEmpty())return -1
        };
        return states.values.min()
    };
    private fun upperBound(values:IntArray,target:Int):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1 else right=middle
        };
        return left
    }
}
