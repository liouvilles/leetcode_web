class Solution {
    private fun isPrime(value:Int):Boolean{
        if(value<2)return false;
        var divisor=2;
        while(divisor*divisor<=value){
            if(value%divisor==0)return false;
            divisor++
        };
        return true
    }
    fun maximumPrimeDifference(nums:IntArray):Int{
        var first=-1;
        var last=-1;
        for(index in nums.indices)if(isPrime(nums[index])){
            if(first<0)first=index;
            last=index
        };
        return last-first
    }
}
