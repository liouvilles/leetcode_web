class Solution {
    fun maxSum(nums:List<Int>,k:Int):Int{
        val mod=1000000007L;
        val count=IntArray(31);
        for(value in nums)for(bit in 0 until 31)if(value and (1 shl bit)!=0)count[bit]++;
        var answer=0L;
        repeat(k){
            var value=0;
            for(bit in 0 until 31)if(count[bit]>0){
                value=value or (1 shl bit);
                count[bit]--
            };
            answer=(answer+value.toLong()*value)%mod
        };
        return answer.toInt()
    }
}
