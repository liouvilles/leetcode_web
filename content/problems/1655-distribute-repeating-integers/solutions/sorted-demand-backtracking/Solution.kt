class Solution {
    private fun assign(index:Int,quantity:IntArray,capacity:IntArray):Boolean{
        if(index<0)return true;
        var previous=-1;
        for(i in capacity.indices)if(capacity[i]>=quantity[index]&&capacity[i]!=previous){
            val before=capacity[i];
            capacity[i]-=quantity[index];
            if(assign(index-1,quantity,capacity))return true;
            capacity[i]=before;
            previous=before
        };
        return false
    };
    fun canDistribute(nums:IntArray,quantity:IntArray):Boolean{
        val capacity=nums.toList().groupingBy{
            it
        }.eachCount().values.toIntArray();
        quantity.sort();
        return assign(quantity.lastIndex,quantity,capacity)
    }
}
