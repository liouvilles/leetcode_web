class Solution {
    fun vowelStrings(words:Array<String>,left:Int,right:Int):Int{
        var answer=0;
        for(i in left..right){
            val word=words[i];
            if(word.first() in "aeiou"&&word.last() in "aeiou")answer++
        };
        return answer
    }
}
