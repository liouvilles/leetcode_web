class Solution {
    private val limit=2000000001L;
    fun nthUglyNumber(n:Int,a:Int,b:Int,c:Int):Int{
        val ab=lcm(a.toLong(),b.toLong());
        val ac=lcm(a.toLong(),c.toLong());
        val bc=lcm(b.toLong(),c.toLong());
        val abc=lcm(ab,c.toLong());
        var left=1L;
        var right=2000000000L;
        while(left<right){
            val middle=(left+right)/2;
            val count=middle/a+middle/b+middle/c-middle/ab-middle/ac-middle/bc+middle/abc;
            if(count>=n)right=middle else left=middle+1
        };
        return left.toInt()
    };
    private fun gcd(first:Long,second:Long):Long{
        var a=first;
        var b=second;
        while(b!=0L){
            val remainder=a%b;
            a=b;
            b=remainder
        };
        return a
    };
    private fun lcm(a:Long,b:Long):Long{
        val divided=a/gcd(a,b);
        return if(divided>limit/b)limit else divided*b
    }
}
