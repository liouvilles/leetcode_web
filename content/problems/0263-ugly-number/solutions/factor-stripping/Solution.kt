class Solution {
    fun isUgly(input:Int):Boolean{
        if(input<=0)return false;
        var n=input;
        for(factor in intArrayOf(2,3,5))while(n%factor==0)n/=factor;
        return n==1
    }
}
