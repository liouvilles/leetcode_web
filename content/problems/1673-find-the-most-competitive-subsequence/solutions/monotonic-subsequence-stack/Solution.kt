class Solution {
    fun mostCompetitive(nums:IntArray,k:Int):IntArray{
        val stack=IntArray(k);
        var size=0;
        for(i in nums.indices){
            while(size>0&&stack[size-1]>nums[i]&&size-1+nums.size-i>=k)size--;
            if(size<k)stack[size++]=nums[i]
        };
        return stack
    }
}
