class Solution {
    fun minimumLevels(possible:IntArray):Int{
        var total=0;
        for(value in possible)total+=if(value==1)1 else -1;
        var prefix=0;
        for(index in 0 until possible.lastIndex){
            prefix+=if(possible[index]==1)1 else -1;
            if(prefix>total-prefix)return index+1
        };
        return -1
    }
}
