class Solution {
    fun addMinimum(word:String):Int{
        var groups=1;
        for(i in 1 until word.length)if(word[i]<=word[i-1])groups++;
        return groups*3-word.length
    }
}
