class Solution {
    fun sumImbalanceNumbers(nums:IntArray):Int{
        var answer=0;
        val n=nums.size;
        val maximum=nums.maxOrNull()!!;
        for(left in nums.indices){
            val seen=BooleanArray(maximum+2);
            seen[nums[left]]=true;
            var imbalance=0;
            for(right in left+1 until n){
                val value=nums[right];
                if(!seen[value]){
                    imbalance++;
                    if(seen[value-1])imbalance--;
                    if(seen[value+1])imbalance--;
                    seen[value]=true
                };
                answer+=imbalance
            }
        };
        return answer
    }
}
