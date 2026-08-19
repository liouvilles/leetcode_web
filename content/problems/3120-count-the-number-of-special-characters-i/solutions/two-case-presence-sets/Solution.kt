class Solution {
    fun numberOfSpecialChars(word:String):Int{
        val lowercase=BooleanArray(26);
        val uppercase=BooleanArray(26);
        for(letter in word)if(letter.isLowerCase())lowercase[letter-'a']=true else uppercase[letter-'A']=true;
        var answer=0;
        for(index in 0 until 26)if(lowercase[index]&&uppercase[index])answer++;
        return answer
    }
}
