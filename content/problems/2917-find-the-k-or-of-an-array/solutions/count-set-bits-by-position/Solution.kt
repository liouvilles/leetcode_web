class Solution {
    fun findKOr(nums:IntArray,k:Int):Int{
        var answer=0;
        for(bit in 0 until 31){
            var count=0;
            val mask=1 shl bit;
            for(value in nums)if((value and mask)!=0)count++;
            if(count>=k)answer=answer or mask
        };
        return answer
    }
}
