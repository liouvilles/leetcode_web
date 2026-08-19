class Solution {
    fun maxNonOverlapping(nums:IntArray,target:Int):Int{
        val seen=mutableSetOf(0);
        var prefix=0;
        var answer=0;
        for(value in nums){
            prefix+=value;
            if(prefix-target in seen){
                answer++;
                seen.clear();
                seen.add(0);
                prefix=0
            }else seen.add(prefix)
        };
        return answer
    }
}
