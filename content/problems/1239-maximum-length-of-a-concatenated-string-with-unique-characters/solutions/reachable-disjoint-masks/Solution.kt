class Solution {
    fun maxLength(arr:List<String>):Int{
        val states=mutableListOf(0);
        var answer=0;
        for(word in arr){
            var mask=0;
            var valid=true;
            for(ch in word){
                val bit=1 shl (ch-'a');
                if(mask and bit!=0){
                    valid=false;
                    break
                };
                mask=mask or bit
            };
            if(!valid)continue;
            val size=states.size;
            for(i in 0 until size)if(states[i] and mask==0){
                val combined=states[i] or mask;
                states.add(combined);
                answer=maxOf(answer,Integer.bitCount(combined))
            }
        };
        return answer
    }
}
