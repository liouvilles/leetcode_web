class Solution {
    fun tupleSameProduct(nums:IntArray):Int{
        val frequency=mutableMapOf<Int,Int>();
        var answer=0;
        for(left in nums.indices)for(right in left+1 until nums.size){
            val product=nums[left]*nums[right];
            answer+=8*(frequency[product]?:0);
            frequency[product]=(frequency[product]?:0)+1
        };
        return answer
    }
}
