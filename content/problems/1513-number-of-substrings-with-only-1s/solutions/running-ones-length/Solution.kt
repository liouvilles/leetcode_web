class Solution {
    fun numSub(text:String):Int{
        val mod=1_000_000_007L;
        var answer=0L;
        var running=0L;
        for(value in text){
            running=if(value=='1')running+1 else 0;
            answer=(answer+running)%mod
        };
        return answer.toInt()
    }
}
