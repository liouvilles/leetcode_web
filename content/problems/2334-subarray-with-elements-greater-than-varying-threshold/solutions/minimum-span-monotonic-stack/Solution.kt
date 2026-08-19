class Solution {
    fun validSubarraySize(nums:IntArray,threshold:Int):Int{
        val n=nums.size;
        val left=IntArray(n);
        val right=IntArray(n);
        val stack=java.util.ArrayDeque<Int>();
        for(i in 0 until n){
            while(stack.isNotEmpty()&&nums[stack.peek()]>=nums[i])stack.pop();
            left[i]=if(stack.isEmpty())-1 else stack.peek();
            stack.push(i)
        };
        stack.clear();
        for(i in n-1 downTo 0){
            while(stack.isNotEmpty()&&nums[stack.peek()]>=nums[i])stack.pop();
            right[i]=if(stack.isEmpty())n else stack.peek();
            stack.push(i)
        };
        for(i in 0 until n){
            val length=right[i]-left[i]-1;
            if(nums[i].toLong()*length>threshold)return length
        };
        return -1
    }
}
