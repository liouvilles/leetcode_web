class Solution {
    fun subarraysDivByK(nums:IntArray,k:Int):Int{
        val frequency=IntArray(k);
        frequency[0]=1;
        var remainder=0;
        var answer=0;
        for(value in nums){
            remainder=((remainder+value)%k+k)%k;
            answer+=frequency[remainder]++
        };
        return answer
    }
}
