class Solution {
    fun frequencySort(s:String):String{
        val counts=IntArray(128);
        for(c in s)counts[c.code]++;
        val chars=(counts.indices.filter{
            counts[it]>0
        }).sortedWith(compareByDescending<Int>{
            counts[it]
        }.thenBy{
            it
        });
        val answer=StringBuilder();
        for(c in chars)repeat(counts[c]){
            answer.append(c.toChar())
        };
        return answer.toString()
    }
}
