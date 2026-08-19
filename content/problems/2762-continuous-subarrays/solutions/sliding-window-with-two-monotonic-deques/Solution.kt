class Solution {
    fun continuousSubarrays(nums:IntArray):Long{
        val maximum=java.util.ArrayDeque<Int>();
        val minimum=java.util.ArrayDeque<Int>();
        var left=0;
        var answer=0L;
        for(right in nums.indices){
            while(!maximum.isEmpty()&&nums[maximum.peekLast()]<nums[right])maximum.pollLast();
            while(!minimum.isEmpty()&&nums[minimum.peekLast()]>nums[right])minimum.pollLast();
            maximum.addLast(right);
            minimum.addLast(right);
            while(nums[maximum.peekFirst()]-nums[minimum.peekFirst()]>2){
                if(maximum.peekFirst()==left)maximum.pollFirst();
                if(minimum.peekFirst()==left)minimum.pollFirst();
                left++
            };
            answer+=right-left+1
        };
        return answer
    }
}
