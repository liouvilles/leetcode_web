class Solution {
    fun increasingTriplet(nums:IntArray):Boolean{
        var first=Int.MAX_VALUE;
        var second=Int.MAX_VALUE;
        for(value in nums){
            if(value<=first)first=value else if(value<=second)second=value else return true
        };
        return false
    }
}
