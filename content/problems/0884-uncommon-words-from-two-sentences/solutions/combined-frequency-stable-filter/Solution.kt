class Solution {
    fun uncommonFromSentences(s1:String,s2:String):Array<String>{
        val words=(s1+" "+s2).split(' ');
        val frequency=words.groupingBy{
            it
        }.eachCount();
        return words.filter{
            frequency[it]==1
        }.toTypedArray()
    }
}
