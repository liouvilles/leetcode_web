class Solution {
    fun findingUsersActiveMinutes(logs:Array<IntArray>,k:Int):IntArray{
        val minutes=mutableMapOf<Int,MutableSet<Int>>();
        for(log in logs)minutes.getOrPut(log[0]){
            mutableSetOf()
        }.add(log[1]);
        val answer=IntArray(k);
        for(set in minutes.values)answer[set.size-1]++;
        return answer
    }
}
