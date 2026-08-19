class Solution {
    fun canSeePersonsCount(heights:IntArray):IntArray{
        val answer=IntArray(heights.size);
        val stack=java.util.ArrayDeque<Int>();
        for(i in heights.lastIndex downTo 0){
            while(stack.isNotEmpty()&&stack.peek()<heights[i]){
                stack.pop();
                answer[i]++
            };
            if(stack.isNotEmpty())answer[i]++;
            stack.push(heights[i])
        };
        return answer
    }
}
