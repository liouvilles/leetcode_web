class Solution {
    fun maximumSubsequenceCount(text:String,pattern:String):Long{
        var first=0L;
        var second=0L;
        var existing=0L;
        for(ch in text){
            if(ch==pattern[1]){
                existing+=first;
                second++
            };
            if(ch==pattern[0])first++
        };
        return existing+maxOf(first,second)
    }
}
