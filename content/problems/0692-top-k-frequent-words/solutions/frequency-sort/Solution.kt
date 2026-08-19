class Solution {
    fun topKFrequent(words:Array<String>,k:Int):List<String>{
        val counts=words.groupingBy{
            it
        }.eachCount();
        return counts.keys.sortedWith(compareByDescending<String>{
            counts[it]
        }.thenBy{
            it
        }).take(k)
    }
}
