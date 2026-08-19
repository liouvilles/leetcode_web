class Solution {
    fun findKthBit(n:Int,k:Int):Char{
        if(n==1)return '0';
        val length=(1 shl n)-1;
        val middle=1 shl (n-1);
        if(k==middle)return '1';
        if(k<middle)return findKthBit(n-1,k);
        return if(findKthBit(n-1,length-k+1)=='0')'1' else '0'
    }
}
