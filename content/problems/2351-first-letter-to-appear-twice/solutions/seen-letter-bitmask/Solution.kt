class Solution {
    fun repeatedCharacter(s:String):Char{
        var mask=0;
        for(ch in s){
            val bit=1 shl (ch-'a');
            if(mask and bit!=0)return ch;
            mask=mask or bit
        };
        error("answer guaranteed")
    }
}
