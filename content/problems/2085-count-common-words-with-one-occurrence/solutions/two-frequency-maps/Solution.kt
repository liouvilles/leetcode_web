class Solution {
    fun countWords(words1:Array<String>,words2:Array<String>):Int{
        val first=words1.groupingBy{
            it
        }.eachCount();
        val second=words2.groupingBy{
            it
        }.eachCount();
        return first.count{
            it.value==1&&second[it.key]==1
        }
    }
}
