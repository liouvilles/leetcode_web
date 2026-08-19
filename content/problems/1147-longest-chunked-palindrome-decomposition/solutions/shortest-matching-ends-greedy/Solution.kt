class Solution {
    fun longestDecomposition(text:String):Int{
        val n=text.length;
        if(n==0)return 0;
        for(length in 1..n/2)if(text.regionMatches(0,text,n-length,length))return 2+longestDecomposition(text.substring(length,n-length));
        return 1
    }
}
