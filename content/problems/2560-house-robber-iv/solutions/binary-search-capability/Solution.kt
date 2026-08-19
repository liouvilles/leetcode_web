class Solution {
    fun minCapability(nums:IntArray,k:Int):Int{
        fun possible(limit:Int):Boolean{
            var count=0;
            var i=0;
            while(i<nums.size){
                if(nums[i]<=limit){
                    count++;
                    i+=2
                }else i++
            };
            return count>=k
        };
        var left=nums.minOrNull()!!;
        var right=nums.maxOrNull()!!;
        while(left<right){
            val middle=left+(right-left)/2;
            if(possible(middle))right=middle else left=middle+1
        };
        return left
    }
}
