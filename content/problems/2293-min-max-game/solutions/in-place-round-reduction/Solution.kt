class Solution {
    fun minMaxGame(nums:IntArray):Int{
        var length=nums.size;
        while(length>1){
            for(i in 0 until length/2)nums[i]=if(i%2==0)minOf(nums[2*i],nums[2*i+1])else maxOf(nums[2*i],nums[2*i+1]);
            length/=2
        };
        return nums[0]
    }
}
