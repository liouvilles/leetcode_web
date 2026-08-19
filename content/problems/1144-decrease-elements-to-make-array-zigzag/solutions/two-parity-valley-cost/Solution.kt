class Solution {
    fun movesToMakeZigzag(nums:IntArray):Int=minOf(cost(nums,0),cost(nums,1));
    private fun cost(nums:IntArray,parity:Int):Int{
        var moves=0;
        for(i in parity until nums.size step 2){
            val left=if(i>0)nums[i-1] else 1000000000;
            val right=if(i+1<nums.size)nums[i+1] else 1000000000;
            moves+=maxOf(0,nums[i]-minOf(left,right)+1)
        };
        return moves
    }
}
