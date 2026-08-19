class Solution {
    fun findRepeatedDnaSequences(s:String):List<String>{
        val seen=hashSetOf<String>();
        val repeated=linkedSetOf<String>();
        for(i in 0..s.length-10){
            val part=s.substring(i,i+10);
            if(!seen.add(part)) repeated.add(part)
        };
        return repeated.toList()
    }
}
