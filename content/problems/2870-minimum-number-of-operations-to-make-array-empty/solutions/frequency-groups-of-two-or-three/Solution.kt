class Solution {
    fun minOperations(nums:IntArray):Int{
        val frequency=HashMap<Int,Int>();
        for(value in nums)frequency[value]=(frequency[value]?:0)+1;
        var operations=0;
        for(count in frequency.values){
            if(count==1)return -1;
            operations+=(count+2)/3
        };
        return operations
    }
}
