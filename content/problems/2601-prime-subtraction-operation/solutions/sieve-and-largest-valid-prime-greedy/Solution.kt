class Solution {
    fun primeSubOperation(nums:IntArray):Boolean{
        val maximum=nums.maxOrNull()!!;
        val composite=BooleanArray(maximum+1);
        val primes=mutableListOf<Int>();
        for(number in 2..maximum)if(!composite[number]){
            primes.add(number);
            if(number.toLong()*number<=maximum){
                var multiple=number*number;
                while(multiple<=maximum){
                    composite[multiple]=true;
                    multiple+=number
                }
            }
        };
        var previous=0;
        for(original in nums){
            if(original<=previous)return false;
            val limit=original-previous;
            var left=0;
            var right=primes.size;
            while(left<right){
                val middle=(left+right)/2;
                if(primes[middle]<limit)left=middle+1 else right=middle
            };
            var current=original;
            if(left>0)current-=primes[left-1];
            previous=current
        };
        return true
    }
}
