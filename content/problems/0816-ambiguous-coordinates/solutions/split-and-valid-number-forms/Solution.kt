class Solution {
    fun ambiguousCoordinates(s:String):List<String>{
        val digits=s.substring(1,s.length-1);
        val answer=mutableListOf<String>();
        for(split in 1 until digits.length)for(left in forms(digits.substring(0,split)))for(right in forms(digits.substring(split)))answer.add("($left, $right)");
        return answer
    };
    private fun forms(part:String):List<String>{
        val result=mutableListOf<String>();
        if(part.length==1||part[0]!='0')result.add(part);
        for(dot in 1 until part.length){
            val integer=part.substring(0,dot);
            val fraction=part.substring(dot);
            if((integer.length==1||integer[0]!='0')&&fraction.last()!='0')result.add("$integer.$fraction")
        };
        return result
    }
}
