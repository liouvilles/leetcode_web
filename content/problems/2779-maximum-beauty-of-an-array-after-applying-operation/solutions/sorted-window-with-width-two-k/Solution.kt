class Solution {
    fun maximumBeauty(nums:IntArray,k:Int):Int{
        nums.sort();
        var left=0;
        var answer=0;
        for(right in nums.indices){
            while(nums[right].toLong()-nums[left]>2L*k)left++;
            answer=maxOf(answer,right-left+1)
        };
        return answer
    }
}
