class Solution {
    fun findLUSlength(strs:Array<String>):Int{
        strs.sortWith(compareByDescending<String>{
            it.length
        }.thenBy{
            it
        });
        fun subsequence(small:String,large:String):Boolean{
            var index=0;
            for(c in large)if(index<small.length&&small[index]==c)index++;
            return index==small.length
        };
        for(i in strs.indices)if(strs.indices.none{
            it!=i&&subsequence(strs[i],strs[it])
        })return strs[i].length;
        return -1
    }
}
