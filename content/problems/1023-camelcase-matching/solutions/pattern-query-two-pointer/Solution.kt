class Solution {
    fun camelMatch(queries:Array<String>,pattern:String):List<Boolean>{
        return queries.map{
            query->var index=0;
            var valid=true;
            for(ch in query)if(index<pattern.length&&ch==pattern[index])index++ else if(ch.isUpperCase()){
                valid=false;
                break
            };
            valid&&index==pattern.length
        }
    }
}
