class Solution {
    fun findMaximumXOR(nums:IntArray):Int{
        var answer=0;
        var mask=0;
        for(bit in 30 downTo 0){
            mask=mask or (1 shl bit);
            val prefixes=nums.mapTo(hashSetOf()){
                it and mask
            };
            val candidate=answer or (1 shl bit);
            if(prefixes.any{
                (it xor candidate) in prefixes
            })answer=candidate
        };
        return answer
    }
}
