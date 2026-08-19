class Solution {
    fun maximumCostSubstring(s:String,chars:String,vals:IntArray):Int{
        val value=IntArray(26){
            it+1
        };
        for(i in chars.indices)value[chars[i]-'a']=vals[i];
        var current=0;
        var answer=0;
        for(letter in s){
            current=maxOf(0,current+value[letter-'a']);
            answer=maxOf(answer,current)
        };
        return answer
    }
}
