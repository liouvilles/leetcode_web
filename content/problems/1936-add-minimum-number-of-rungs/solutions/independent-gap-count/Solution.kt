class Solution {
    fun addRungs(rungs:IntArray,dist:Int):Int{
        var answer=0;
        var previous=0;
        for(rung in rungs){
            answer+=(rung-previous-1)/dist;
            previous=rung
        };
        return answer
    }
}
