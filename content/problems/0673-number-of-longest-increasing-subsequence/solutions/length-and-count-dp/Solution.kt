class Solution {
    fun findNumberOfLIS(nums:IntArray):Int{
        val length=IntArray(nums.size){
            1
        };
        val count=IntArray(nums.size){
            1
        };
        var longest=1;
        for(i in nums.indices){
            for(j in 0 until i)if(nums[j]<nums[i]){
                if(length[j]+1>length[i]){
                    length[i]=length[j]+1;
                    count[i]=count[j]
                }else if(length[j]+1==length[i])count[i]+=count[j]
            };
            longest=maxOf(longest,length[i])
        };
        var answer=0;
        for(i in nums.indices)if(length[i]==longest)answer+=count[i];
        return answer
    }
}
