class Solution {
    fun beautySum(text:String):Int{
        var answer=0;
        for(left in text.indices){
            val frequency=IntArray(26);
            for(right in left until text.length){
                frequency[text[right]-'a']++;
                var maximum=0;
                var minimum=Int.MAX_VALUE;
                for(count in frequency)if(count>0){
                    maximum=maxOf(maximum,count);
                    minimum=minOf(minimum,count)
                };
                answer+=maximum-minimum
            }
        };
        return answer
    }
}
