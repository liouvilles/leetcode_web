class Solution {
    fun closestToTarget(arr:IntArray,target:Int):Int{
        var previous=emptySet<Int>();
        var answer=Int.MAX_VALUE;
        for(value in arr){
            val current=mutableSetOf(value);
            for(old in previous)current.add(old and value);
            for(result in current)answer=minOf(answer,kotlin.math.abs(result-target));
            previous=current
        };
        return answer
    }
}
