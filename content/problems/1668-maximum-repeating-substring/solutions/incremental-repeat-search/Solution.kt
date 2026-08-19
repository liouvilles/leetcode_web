class Solution {
    fun maxRepeating(sequence:String,word:String):Int{
        var candidate=word;
        var answer=0;
        while(sequence.contains(candidate)){
            answer++;
            candidate+=word
        };
        return answer
    }
}
