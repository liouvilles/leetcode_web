class Solution {
    fun sumBase(nValue:Int,k:Int):Int{
        var n=nValue;
        var sum=0;
        while(n>0){
            sum+=n%k;
            n/=k
        };
        return sum
    }
}
