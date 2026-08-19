class Solution {
    fun minOperations(nums:List<Int>,k:Int):Int{
        val collected=BooleanArray(k+1);
        var missing=k;
        for(i in nums.indices.reversed()){
            val value=nums[i];
            if(value<=k&&!collected[value]){
                collected[value]=true;
                missing--
            };
            if(missing==0)return nums.size-i
        };
        return nums.size
    }
}
