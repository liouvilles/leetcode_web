class Solution {
    fun maximumLength(nums:IntArray):Int{
        val frequency=HashMap<Long,Int>();
        for(value in nums){
            val key=value.toLong();
            frequency[key]=(frequency[key]?:0)+1
        };
        var answer=1;
        val ones=frequency[1L]?:0;
        if(ones>0)answer=if(ones and 1==1)ones else ones-1;
        for(start in frequency.keys){
            if(start==1L)continue;
            var length=0;
            var value=start;
            while((frequency[value]?:0)>=2){
                length+=2;
                value*=value
            };
            length+=if((frequency[value]?:0)>0)1 else -1;
            answer=maxOf(answer,length)
        };
        return answer
    }
}
