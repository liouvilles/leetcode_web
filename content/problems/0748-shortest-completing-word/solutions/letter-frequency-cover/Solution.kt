class Solution {
    fun shortestCompletingWord(licensePlate:String,words:Array<String>):String{
        val required=count(licensePlate);
        var answer:String?=null;
        for(word in words)if((answer==null||word.length<answer!!.length)&&covers(count(word),required))answer=word;
        return answer!!
    };
    private fun count(value:String):IntArray{
        val counts=IntArray(26);
        for(raw in value){
            val c=raw.lowercaseChar();
            if(c in 'a'..'z')counts[c-'a']++
        };
        return counts
    };
    private fun covers(available:IntArray,required:IntArray)=available.indices.all{
        available[it]>=required[it]
    }
}
