class Solution {
    fun minOrAfterOperations(nums:IntArray,k:Int):Int{
        val n=nums.size;
        var zeroMask=0;
        var answer=0;
        for(bit in 29 downTo 0){
            val bitValue=1 shl bit;
            val candidate=zeroMask or bitValue;
            var groups=0;
            var current=candidate;
            for(value in nums){
                current=current and value;
                if(current==0){
                    groups++;
                    current=candidate
                }
            };
            if(n-groups<=k)zeroMask=candidate else answer=answer or bitValue
        };
        return answer
    }
}
