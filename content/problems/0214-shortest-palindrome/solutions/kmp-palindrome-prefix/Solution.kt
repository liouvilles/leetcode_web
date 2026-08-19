class Solution {
    fun shortestPalindrome(s:String):String{
        val reversed=s.reversed();
        val combined=s+"#"+reversed;
        val prefix=IntArray(combined.length);
        for(i in 1 until combined.length){
            var j=prefix[i-1];
            while(j>0&&combined[i]!=combined[j])j=prefix[j-1];
            if(combined[i]==combined[j])j++;
            prefix[i]=j
        };
        val length=if(prefix.isEmpty())0 else prefix.last();
        return reversed.substring(0,s.length-length)+s
    }
}
