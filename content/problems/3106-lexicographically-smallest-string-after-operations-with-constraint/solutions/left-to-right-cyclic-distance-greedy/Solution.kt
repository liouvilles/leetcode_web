class Solution {
    fun getSmallestString(s:String,k:Int):String{
        val letters=s.toCharArray();
        var remaining=k;
        for(index in letters.indices){
            if(remaining==0)break;
            val direct=letters[index]-'a';
            val distance=minOf(direct,26-direct);
            if(distance<=remaining){
                letters[index]='a';
                remaining-=distance
            }else{
                letters[index]=(letters[index].code-remaining).toChar();
                remaining=0
            }
        };
        return letters.concatToString()
    }
}
