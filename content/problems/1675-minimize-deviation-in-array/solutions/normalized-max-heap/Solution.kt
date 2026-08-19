class Solution {
    fun minimumDeviation(nums:IntArray):Int{
        val maximums=java.util.PriorityQueue<Int>(reverseOrder());
        var minimum=Int.MAX_VALUE;
        for(original in nums){
            val value=if(original%2==1)original*2 else original;
            maximums.add(value);
            minimum=minOf(minimum,value)
        };
        var answer=Int.MAX_VALUE;
        while(true){
            var maximum=maximums.remove();
            answer=minOf(answer,maximum-minimum);
            if(maximum%2==1)break;
            maximum/=2;
            minimum=minOf(minimum,maximum);
            maximums.add(maximum)
        };
        return answer
    }
}
