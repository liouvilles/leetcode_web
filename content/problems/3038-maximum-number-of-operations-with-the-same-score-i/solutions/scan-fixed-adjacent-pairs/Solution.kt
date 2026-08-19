class Solution {
    fun maxOperations(nums:IntArray):Int{
        val target=nums[0]+nums[1];
        var answer=0;
        var index=0;
        while(index+1<nums.size){
            if(nums[index]+nums[index+1]!=target)break;
            answer++;
            index+=2
        };
        return answer
    }
}
