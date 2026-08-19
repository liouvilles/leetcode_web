class Solution {
    fun longestPrefix(text:String):String{
        val prefix=IntArray(text.length);
        for(i in 1 until text.length){
            var length=prefix[i-1];
            while(length>0&&text[i]!=text[length])length=prefix[length-1];
            if(text[i]==text[length])length++;
            prefix[i]=length
        };
        return text.substring(0,prefix[text.lastIndex])
    }
}
