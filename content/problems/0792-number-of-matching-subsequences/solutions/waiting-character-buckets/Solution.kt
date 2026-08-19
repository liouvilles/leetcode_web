class Solution {
    fun numMatchingSubseq(s:String,words:Array<String>):Int{
        val buckets=Array(26){
            java.util.ArrayDeque<IntArray>()
        };
        for(i in words.indices)buckets[words[i][0]-'a'].addLast(intArrayOf(i,0));
        var answer=0;
        for(c in s){
            val queue=buckets[c-'a'];
            repeat(queue.size){
                val state=queue.removeFirst();
                state[1]++;
                if(state[1]==words[state[0]].length)answer++ else buckets[words[state[0]][state[1]]-'a'].addLast(state)
            }
        };
        return answer
    }
}
