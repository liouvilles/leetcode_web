class Solution {
    fun removeAlmostEqualCharacters(word:String):Int{
        var operations=0;
        var index=1;
        while(index<word.length){
            if(kotlin.math.abs(word[index]-word[index-1])<=1){
                operations++;
                index+=2
            }else index++
        };
        return operations
    }
}
