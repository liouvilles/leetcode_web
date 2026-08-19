class Solution {
    fun maximumTop(nums:IntArray,k:Int):Int{
        if(k==0)return nums[0];
        if(nums.size==1)return if(k%2==0)nums[0]else -1;
        var answer=-1;
        for(i in 0 until minOf(nums.size,k-1))answer=maxOf(answer,nums[i]);
        if(k<nums.size)answer=maxOf(answer,nums[k]);
        return answer
    }
}
