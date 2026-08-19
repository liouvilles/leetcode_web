class Solution {
    fun repeatLimitedString(s:String,repeatLimit:Int):String{
        val count=IntArray(26);
        for(ch in s)count[ch-'a']++;
        val answer=StringBuilder();
        var current=25;
        while(current>=0){
            while(current>=0&&count[current]==0)current--;
            if(current<0)break;
            val take=minOf(count[current],repeatLimit);
            repeat(take){
                answer.append(('a'.code+current).toChar())
            };
            count[current]-=take;
            if(count[current]==0)continue;
            var separator=current-1;
            while(separator>=0&&count[separator]==0)separator--;
            if(separator<0)break;
            answer.append(('a'.code+separator).toChar());
            count[separator]--
        };
        return answer.toString()
    }
}
