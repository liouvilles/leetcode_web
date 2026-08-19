class Solution {
    fun largestSumAfterKNegations(nums:IntArray,kInput:Int):Int{
        nums.sort();
        var k=kInput;
        var i=0;
        while(i<nums.size&&k>0&&nums[i]<0){
            nums[i]=-nums[i];
            i++;
            k--
        };
        val sum=nums.sum();
        val minimum=nums.minOf{
            kotlin.math.abs(it)
        };
        return if(k%2==0)sum else sum-2*minimum
    }
}
