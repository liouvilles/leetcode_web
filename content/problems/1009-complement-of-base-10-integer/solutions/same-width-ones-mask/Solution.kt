class Solution {
    fun bitwiseComplement(n:Int):Int{
        if(n==0)return 1;
        var mask=0;
        var copy=n;
        while(copy>0){
            mask=(mask shl 1) or 1;
            copy=copy shr 1
        };
        return n xor mask
    }
}
