class Solution {
    fun preimageSizeFZF(k:Int):Int=(lowerBound(k.toLong()+1)-lowerBound(k.toLong())).toInt();
    private fun lowerBound(target:Long):Long{
        var low=0L;
        var high=5*(target+1);
        while(low<high){
            val middle=low+(high-low)/2;
            if(zeroes(middle)>=target)high=middle else low=middle+1
        };
        return low
    };
    private fun zeroes(input:Long):Long{
        var value=input;
        var result=0L;
        while(value>0){
            value/=5;
            result+=value
        };
        return result
    }
}
