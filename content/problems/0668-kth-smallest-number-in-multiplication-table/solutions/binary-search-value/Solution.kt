class Solution {
    fun findKthNumber(m:Int,n:Int,k:Int):Int{
        var left=1;
        var right=m*n;
        while(left<right){
            val middle=left+(right-left)/2;
            var count=0;
            for(row in 1..m)count+=minOf(n,middle/row);
            if(count>=k)right=middle else left=middle+1
        };
        return left
    }
}
