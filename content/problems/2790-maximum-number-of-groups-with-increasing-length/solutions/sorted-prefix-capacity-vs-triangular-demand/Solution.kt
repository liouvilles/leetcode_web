class Solution {
    fun maxIncreasingGroups(usageLimits:List<Int>):Int{
        var total=0L;
        var groups=0;
        for(limit in usageLimits.sorted()){
            total+=limit;
            val next=groups+1L;
            if(total>=next*(next+1)/2)groups++
        };
        return groups
    }
}
