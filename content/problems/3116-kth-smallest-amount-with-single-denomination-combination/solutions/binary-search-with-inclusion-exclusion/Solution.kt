class Solution {
    private fun gcd(firstValue:Long,secondValue:Long):Long{
        var first=firstValue;
        var second=secondValue;
        while(second!=0L){
            val value=first%second;
            first=second;
            second=value
        };
        return first
    }
    private fun count(coins:IntArray,limit:Long):Long{
        var total=0L;
        for(mask in 1 until (1 shl coins.size)){
            var lcm=1L;
            var bits=0;
            var tooLarge=false;
            for(index in coins.indices)if(mask and (1 shl index)!=0){
                bits++;
                val divisor=gcd(lcm,coins[index].toLong());
                if(lcm/divisor>limit/coins[index]){
                    tooLarge=true;
                    break
                };
                lcm=lcm/divisor*coins[index]
            };
            if(!tooLarge){
                val occurrences=limit/lcm;
                total+=if(bits and 1==1)occurrences else -occurrences
            }
        };
        return total
    }
    fun findKthSmallest(coins:IntArray,k:Int):Long{
        var low=1L;
        var high=coins.min().toLong()*k;
        while(low<high){
            val middle=low+(high-low)/2;
            if(count(coins,middle)>=k)high=middle else low=middle+1
        };
        return low
    }
}
