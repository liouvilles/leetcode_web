class Solution {
    fun calPoints(operations:Array<String>):Int{
        val scores=mutableListOf<Int>();
        for(operation in operations)when(operation){
            "C"->scores.removeAt(scores.lastIndex);
            "D"->scores.add(scores.last()*2);
            "+"->scores.add(scores.last()+scores[scores.lastIndex-1]);
            else->scores.add(operation.toInt())
        };
        return scores.sum()
    }
}
