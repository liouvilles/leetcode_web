class Solution {
    private fun add(longest:Array<IntArray>,letter:Int,length:Int){
        if(length>longest[letter][0]){
            longest[letter][2]=longest[letter][1];
            longest[letter][1]=longest[letter][0];
            longest[letter][0]=length
        }else if(length>longest[letter][1]){
            longest[letter][2]=longest[letter][1];
            longest[letter][1]=length
        }else if(length>longest[letter][2])longest[letter][2]=length
    }
    fun maximumLength(s:String):Int{
        val longest=Array(26){
            IntArray(3)
        };
        var start=0;
        while(start<s.length){
            var end=start+1;
            while(end<s.length&&s[end]==s[start])end++;
            add(longest,s[start]-'a',end-start);
            start=end
        };
        var answer=0;
        for(runs in longest)answer=maxOf(answer,runs[0]-2,minOf(runs[0]-1,runs[1]),runs[2]);
        return if(answer>0)answer else -1
    }
}
