class Solution {
    fun minimumScore(s:String,t:String):Int{
        val n=s.length;
        val m=t.length;
        val suffix=IntArray(m+1);
        suffix[m]=n;
        var position=n-1;
        for(i in m-1 downTo 0){
            while(position>=0&&s[position]!=t[i])position--;
            suffix[i]=position;
            position--
        };
        var answer=m;
        var right=0;
        var prefixPosition=-1;
        var searchPosition=0;
        for(left in 0..m){
            right=maxOf(right,left);
            while(right<=m&&suffix[right]<=prefixPosition)right++;
            if(right<=m)answer=minOf(answer,right-left);
            if(left==m)break;
            while(searchPosition<n&&s[searchPosition]!=t[left])searchPosition++;
            if(searchPosition==n)break;
            prefixPosition=searchPosition++
        };
        return answer
    }
}
