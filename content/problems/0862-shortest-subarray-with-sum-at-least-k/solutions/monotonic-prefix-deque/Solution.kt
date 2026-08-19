class Solution {
    fun shortestSubarray(nums:IntArray,k:Int):Int{
        val prefix=LongArray(nums.size+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        val deque=java.util.ArrayDeque<Int>();
        var answer=nums.size+1;
        for(right in prefix.indices){
            while(deque.isNotEmpty()&&prefix[right]-prefix[deque.peekFirst()]>=k)answer=minOf(answer,right-deque.removeFirst());
            while(deque.isNotEmpty()&&prefix[deque.peekLast()]>=prefix[right])deque.removeLast();
            deque.addLast(right)
        };
        return if(answer>nums.size)-1 else answer
    }
}
