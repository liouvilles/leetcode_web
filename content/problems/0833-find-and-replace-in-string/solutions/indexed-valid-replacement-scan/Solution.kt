class Solution {
    fun findReplaceString(s:String,indices:IntArray,sources:Array<String>,targets:Array<String>):String{
        val operations=mutableMapOf<Int,Int>();
        for(i in indices.indices)if(s.startsWith(sources[i],indices[i]))operations[indices[i]]=i;
        val answer=StringBuilder();
        var index=0;
        while(index<s.length){
            val operation=operations[index];
            if(operation==null)answer.append(s[index++])else{
                answer.append(targets[operation]);
                index+=sources[operation].length
            }
        };
        return answer.toString()
    }
}
