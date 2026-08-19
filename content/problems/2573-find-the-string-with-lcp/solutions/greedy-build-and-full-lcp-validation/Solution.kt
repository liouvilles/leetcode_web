class Solution {
    fun findTheString(lcp:Array<IntArray>):String{
        val n=lcp.size;
        val chars=CharArray(n);
        var next='a';
        for(i in 0 until n){
            if(chars[i].code!=0)continue;
            if(next>'z')return "";
            for(j in i until n)if(lcp[i][j]>0)chars[j]=next;
            next++
        };
        val actual=Array(n+1){
            IntArray(n+1)
        };
        for(i in n-1 downTo 0)for(j in n-1 downTo 0){
            if(chars[i]==chars[j])actual[i][j]=actual[i+1][j+1]+1;
            if(actual[i][j]!=lcp[i][j])return ""
        };
        return String(chars)
    }
}
