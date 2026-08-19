class Solution {
    fun repeatedSubstringPattern(s:String):Boolean{
        val prefix=IntArray(s.length);
        for(i in 1 until s.length){
            var j=prefix[i-1];
            while(j>0&&s[i]!=s[j])j=prefix[j-1];
            if(s[i]==s[j])j++;
            prefix[i]=j
        };
        val border=prefix.last();
        val period=s.length-border;
        return border>0&&s.length%period==0
    }
}
