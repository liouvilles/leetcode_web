class Solution {
    fun minimizedMaximum(n:Int,quantities:IntArray):Int{
        var left=1;
        var right=quantities.maxOrNull()!!;
        while(left<right){
            val middle=(left+right)/2;
            var required=0L;
            for(quantity in quantities)required+=(quantity+middle-1)/middle;
            if(required<=n)right=middle else left=middle+1
        };
        return left
    }
}
