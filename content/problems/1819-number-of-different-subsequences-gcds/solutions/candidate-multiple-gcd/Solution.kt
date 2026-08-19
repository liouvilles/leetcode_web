class Solution {
    private fun gcd(a:Int,b:Int):Int=if(b==0)a else gcd(b,a%b);
    fun countDifferentSubsequenceGCDs(nums:IntArray):Int{
        val maximum=nums.maxOrNull()!!;
        val present=BooleanArray(maximum+1);
        for(value in nums)present[value]=true;
        var answer=0;
        for(candidate in 1..maximum){
            var value=0;
            for(multiple in candidate..maximum step candidate)if(present[multiple])value=gcd(value,multiple);
            if(value==candidate)answer++
        };
        return answer
    }
}
