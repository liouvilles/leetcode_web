class Solution {
    fun wordPattern(pattern:String,s:String):Boolean{
        val words=s.split(" ");
        if(pattern.length!=words.size)return false;
        val forward=hashMapOf<Char,String>();
        val reverse=hashMapOf<String,Char>();
        for(i in words.indices){
            val c=pattern[i];
            if(forward.containsKey(c)&&forward[c]!=words[i])return false;
            if(reverse.containsKey(words[i])&&reverse[words[i]]!=c)return false;
            forward[c]=words[i];
            reverse[words[i]]=c
        };
        return true
    }
}
