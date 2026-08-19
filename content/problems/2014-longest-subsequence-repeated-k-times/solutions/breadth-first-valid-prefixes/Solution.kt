class Solution {
    private fun valid(source:String,candidate:String,k:Int):Boolean{
        var index=0;
        var repeats=0;
        for(value in source)if(value==candidate[index]){
            index++;
            if(index==candidate.length){
                index=0;
                if(++repeats==k)return true
            }
        };
        return false
    };
    fun longestSubsequenceRepeatedK(s:String,k:Int):String{
        val frequency=IntArray(26);
        for(value in s)frequency[value-'a']++;
        val alphabet=(0 until 26).filter{
            frequency[it]>=k
        }.map{
            ('a'.code+it).toChar()
        };
        val queue=java.util.ArrayDeque<String>();
        queue.add("");
        var answer="";
        val maximum=s.length/k;
        while(queue.isNotEmpty()){
            val prefix=queue.removeFirst();
            for(letter in alphabet){
                val candidate=prefix+letter;
                if(candidate.length<=maximum&&valid(s,candidate,k)){
                    queue.add(candidate);
                    if(candidate.length>answer.length||candidate.length==answer.length&&candidate>answer)answer=candidate
                }
            }
        };
        return answer
    }
}
