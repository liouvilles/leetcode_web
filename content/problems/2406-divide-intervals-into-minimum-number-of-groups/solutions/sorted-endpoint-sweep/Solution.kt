class Solution {
    fun minGroups(intervals:Array<IntArray>):Int{
        val starts=intervals.map{
            it[0]
        }.sorted();
        val ends=intervals.map{
            it[1]
        }.sorted();
        var i=0;
        var j=0;
        var active=0;
        var answer=0;
        while(i<starts.size){
            if(starts[i]<=ends[j]){
                active++;
                answer=maxOf(answer,active);
                i++
            }else{
                active--;
                j++
            }
        };
        return answer
    }
}
