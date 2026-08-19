class Solution {
    fun shipWithinDays(weights:IntArray,days:Int):Int{
        var left=weights.maxOrNull()!!;
        var right=weights.sum();
        while(left<right){
            val capacity=left+(right-left)/2;
            var needed=1;
            var load=0;
            for(weight in weights){
                if(load+weight>capacity){
                    needed++;
                    load=0
                };
                load+=weight
            };
            if(needed<=days)right=capacity else left=capacity+1
        };
        return left
    }
}
