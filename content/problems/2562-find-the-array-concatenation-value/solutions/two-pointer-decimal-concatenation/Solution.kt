class Solution {
    fun findTheArrayConcVal(nums:IntArray):Long{
        var answer=0L;
        var left=0;
        var right=nums.lastIndex;
        while(left<=right){
            answer+=if(left==right)nums[left].toLong() else (nums[left].toString()+nums[right]).toLong();
            left++;
            right--
        };
        return answer
    }
}
