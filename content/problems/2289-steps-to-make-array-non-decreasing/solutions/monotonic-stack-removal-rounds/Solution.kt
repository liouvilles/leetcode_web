class Solution {
    fun totalSteps(nums:IntArray):Int{
        val stack=java.util.ArrayDeque<IntArray>();
        var answer=0;
        for(value in nums){
            var steps=0;
            while(stack.isNotEmpty()&&stack.peek()[0]<=value)steps=maxOf(steps,stack.pop()[1]);
            steps=if(stack.isNotEmpty())steps+1 else 0;
            answer=maxOf(answer,steps);
            stack.push(intArrayOf(value,steps))
        };
        return answer
    }
}
