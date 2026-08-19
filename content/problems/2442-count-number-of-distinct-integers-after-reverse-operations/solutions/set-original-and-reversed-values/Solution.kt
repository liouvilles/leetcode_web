class Solution {
    fun countDistinctIntegers(nums:IntArray):Int{
        val values=HashSet<Int>();
        for(value in nums){
            values.add(value);
            var x=value;
            var reversed=0;
            while(x>0){
                reversed=reversed*10+x%10;
                x/=10
            };
            values.add(reversed)
        };
        return values.size
    }
}
