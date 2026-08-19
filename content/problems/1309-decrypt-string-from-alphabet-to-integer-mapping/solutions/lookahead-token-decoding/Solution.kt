class Solution {
    fun freqAlphabets(s:String):String{
        val answer=StringBuilder();
        var i=0;
        while(i<s.length){
            val value=if(i+2<s.length&&s[i+2]=='#'){
                val number=(s[i]-'0')*10+(s[i+1]-'0');
                i+=3;
                number
            }else{
                s[i++]-'0'
            };
            answer.append(('a'.code+value-1).toChar())
        };
        return answer.toString()
    }
}
