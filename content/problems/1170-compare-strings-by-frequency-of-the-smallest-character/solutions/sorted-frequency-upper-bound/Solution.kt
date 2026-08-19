class Solution {
    fun numSmallerByFrequency(queries:Array<String>,words:Array<String>):IntArray{
        val frequencies=words.map{
            frequency(it)
        }.sorted();
        return IntArray(queries.size){
            index->val value=frequency(queries[index]);
            var left=0;
            var right=frequencies.size;
            while(left<right){
                val middle=(left+right)/2;
                if(frequencies[middle]<=value)left=middle+1 else right=middle
            };
            frequencies.size-left
        }
    };
    private fun frequency(text:String):Int{
        var minimum='z';
        var count=0;
        for(ch in text)if(ch<minimum){
            minimum=ch;
            count=1
        }else if(ch==minimum)count++;
        return count
    }
}
