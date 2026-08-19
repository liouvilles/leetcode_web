class Solution {
    fun hardestWorker(n:Int,logs:Array<IntArray>):Int{
        var previous=0;
        var best=-1;
        var answer=n;
        for(log in logs){
            val duration=log[1]-previous;
            if(duration>best||duration==best&&log[0]<answer){
                best=duration;
                answer=log[0]
            };
            previous=log[1]
        };
        return answer
    }
}
