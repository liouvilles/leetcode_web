class Solution {
    fun maxStrength(nums:IntArray):Long{
        nums.sort();
        val negativeCount=nums.count{
            it<0
        };
        val hasZero=nums.any{
            it==0
        };
        var product=1L;
        var chosen=0;
        var negativeUsed=0;
        for(value in nums){
            if(value>0){
                product*=value;
                chosen++
            }else if(value<0){
                negativeUsed++;
                if(negativeCount%2==1&&negativeUsed==negativeCount)continue;
                product*=value;
                chosen++
            }
        };
        if(chosen>0)return product;
        if(hasZero)return 0;
        return nums.last().toLong()
    }
}
