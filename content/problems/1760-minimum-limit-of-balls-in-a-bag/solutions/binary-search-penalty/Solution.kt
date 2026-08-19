class Solution {
    fun minimumSize(nums:IntArray,maxOperations:Int):Int{
        var left=1;
        var right=nums.maxOrNull()!!;
        while(left<right){
            val middle=left+(right-left)/2;
            var operations=0L;
            for(value in nums)operations+=(value-1)/middle;
            if(operations<=maxOperations)right=middle else left=middle+1
        };
        return left
    }
}
