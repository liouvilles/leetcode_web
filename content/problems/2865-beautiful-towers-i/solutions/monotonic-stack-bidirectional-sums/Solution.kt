class Solution {
    fun maximumSumOfHeights(heights:IntArray):Long{
        val n=heights.size;
        val left=LongArray(n);
        val right=LongArray(n);
        val stack=java.util.ArrayDeque<Int>();
        for(i in heights.indices){
            val height=heights[i];
            while(stack.isNotEmpty()&&heights[stack.peek()]>height)stack.pop();
            if(stack.isEmpty())left[i]=(i+1L)*height else{
                val previous=stack.peek();
                left[i]=left[previous]+(i-previous).toLong()*height
            };
            stack.push(i)
        };
        stack.clear();
        for(i in n-1 downTo 0){
            val height=heights[i];
            while(stack.isNotEmpty()&&heights[stack.peek()]>height)stack.pop();
            if(stack.isEmpty())right[i]=(n-i).toLong()*height else{
                val previous=stack.peek();
                right[i]=right[previous]+(previous-i).toLong()*height
            };
            stack.push(i)
        };
        var answer=0L;
        for(i in heights.indices)answer=maxOf(answer,left[i]+right[i]-heights[i]);
        return answer
    }
}
