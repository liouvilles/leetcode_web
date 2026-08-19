class Solution {
    fun isOneBitCharacter(bits:IntArray):Boolean{
        var index=0;
        while(index<bits.lastIndex)index+=if(bits[index]==0)1 else 2;
        return index==bits.lastIndex
    }
}
