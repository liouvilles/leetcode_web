class Solution {
    fun sumScores(s:String):Long{
        val n=s.length;
        val z=IntArray(n);
        var left=0;
        var right=0;
        var answer=n.toLong();
        for(i in 1 until n){
            if(i<=right)z[i]=minOf(right-i+1,z[i-left]);
            while(i+z[i]<n&&s[z[i]]==s[i+z[i]])z[i]++;
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1
            };
            answer+=z[i]
        };
        return answer
    }
}
