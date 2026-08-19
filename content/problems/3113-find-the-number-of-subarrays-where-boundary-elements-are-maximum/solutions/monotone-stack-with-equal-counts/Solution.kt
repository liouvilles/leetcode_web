class Solution {
    fun numberOfSubarrays(nums:IntArray):Long{
        val stack=java.util.ArrayDeque<IntArray>();
        var answer=0L;
        for(value in nums){
            while(stack.isNotEmpty()&&stack.peekLast()[0]<value)stack.removeLast();
            if(stack.isEmpty()||stack.peekLast()[0]>value){
                stack.addLast(intArrayOf(value,1));
                answer++
            }else{
                val top=stack.peekLast();
                answer+=top[1]+1L;
                top[1]++
            }
        };
        return answer
    }
}
