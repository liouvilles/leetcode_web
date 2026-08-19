class Solution {
    fun reorderSpaces(text:String):String{
        val spaces=text.count{
            it==' '
        };
        val words=text.trim().split(Regex(" +"));
        val gap=if(words.size==1)0 else spaces/(words.size-1);
        val tail=spaces-gap*(words.size-1);
        return words.joinToString(" ".repeat(gap))+" ".repeat(tail)
    }
}
