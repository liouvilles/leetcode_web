class Solution {
    fun minOperations(nums:List<Int>,target:Int):Int{
        var total=0L;
        val count=LongArray(32);
        for(value in nums){
            total+=value;
            count[Integer.numberOfTrailingZeros(value)]++
        };
        if(total<target)return -1;
        var operations=0;
        for(bit in 0..30){
            if((target shr bit and 1)==1){
                if(count[bit]==0L){
                    var higher=bit+1;
                    while(higher<32&&count[higher]==0L)higher++;
                    while(higher>bit){
                        count[higher]--;
                        count[higher-1]+=2;
                        higher--;
                        operations++
                    }
                };
                count[bit]--
            };
            count[bit+1]+=count[bit]/2
        };
        return operations
    }
}
