class Solution {
    fun countSpecialSubsequences(nums:IntArray):Int{
        val mod=1_000_000_007L;
        var zero=0L;
        var one=0L;
        var two=0L;
        for(value in nums)when(value){
            0->zero=(2*zero+1)%mod;
            1->one=(2*one+zero)%mod;
            else->two=(2*two+one)%mod
        };
        return two.toInt()
    }
}
