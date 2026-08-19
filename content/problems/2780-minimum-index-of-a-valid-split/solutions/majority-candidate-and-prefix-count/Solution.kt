class Solution {
    fun minimumIndex(nums:List<Int>):Int{
        var candidate=0;
        var balance=0;
        for(value in nums){
            if(balance==0)candidate=value;
            balance+=if(value==candidate)1 else -1
        };
        val total=nums.count{
            it==candidate
        };
        var prefix=0;
        for(i in 0 until nums.lastIndex){
            if(nums[i]==candidate)prefix++;
            if(prefix*2>i+1&&(total-prefix)*2>nums.size-i-1)return i
        };
        return -1
    }
}
