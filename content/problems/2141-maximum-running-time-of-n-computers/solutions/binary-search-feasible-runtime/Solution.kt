class Solution {
    fun maxRunTime(n:Int,batteries:IntArray):Long{
        var right=batteries.sumOf{
            it.toLong()
        }/n;
        var left=0L;
        while(left<right){
            val middle=(left+right+1)/2;
            var available=0L;
            for(battery in batteries)available+=minOf(battery.toLong(),middle);
            if(available>=middle*n)left=middle else right=middle-1
        };
        return left
    }
}
