class Solution {
    fun judgeSquareSum(c:Int):Boolean{
        var left=0L;
        var right=kotlin.math.sqrt(c.toDouble()).toLong();
        while(left<=right){
            val sum=left*left+right*right;
            if(sum==c.toLong())return true;
            if(sum<c.toLong())left++ else right--
        };
        return false
    }
}
