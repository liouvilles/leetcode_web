class Solution {
    fun maxLengthBetweenEqualCharacters(text:String):Int{
        val first=IntArray(26){
            -1
        };
        var answer=-1;
        for(i in text.indices){
            val letter=text[i]-'a';
            if(first[letter]<0)first[letter]=i else answer=maxOf(answer,i-first[letter]-1)
        };
        return answer
    }
}
