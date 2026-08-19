class Solution {
    private fun mapped(valueValue:Int,mapping:IntArray):Int{
        if(valueValue==0)return mapping[0];
        var value=valueValue;
        var result=0;
        var place=1;
        while(value>0){
            result+=mapping[value%10]*place;
            place*=10;
            value/=10
        };
        return result
    };
    fun sortJumbled(mapping:IntArray,nums:IntArray):IntArray{
        return nums.indices.sortedWith(compareBy<Int>{
            mapped(nums[it],mapping)
        }.thenBy{
            it
        }).map{
            nums[it]
        }.toIntArray()
    }
}
