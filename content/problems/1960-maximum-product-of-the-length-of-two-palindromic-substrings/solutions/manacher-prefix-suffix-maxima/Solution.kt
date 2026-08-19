class Solution {
    fun maxProduct(s:String):Long{
        val n=s.length;
        val radius=IntArray(n);
        var left=0;
        var right=-1;
        for(i in 0 until n){
            var value=if(i>right)1 else minOf(radius[left+right-i],right-i+1);
            while(i-value>=0&&i+value<n&&s[i-value]==s[i+value])value++;
            radius[i]=value;
            if(i+value-1>right){
                left=i-value+1;
                right=i+value-1
            }
        };
        val end=IntArray(n);
        val start=IntArray(n);
        for(i in 0 until n){
            val length=2*radius[i]-1;
            end[i+radius[i]-1]=maxOf(end[i+radius[i]-1],length);
            start[i-radius[i]+1]=maxOf(start[i-radius[i]+1],length)
        };
        for(i in n-2 downTo 0)end[i]=maxOf(end[i],end[i+1]-2);
        for(i in 1 until n)end[i]=maxOf(end[i],end[i-1]);
        for(i in 1 until n)start[i]=maxOf(start[i],start[i-1]-2);
        for(i in n-2 downTo 0)start[i]=maxOf(start[i],start[i+1]);
        var answer=0L;
        for(i in 0 until n-1)answer=maxOf(answer,end[i].toLong()*start[i+1]);
        return answer
    }
}
