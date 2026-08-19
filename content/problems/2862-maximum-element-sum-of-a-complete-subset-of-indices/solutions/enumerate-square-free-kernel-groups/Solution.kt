class Solution {
    fun maximumSum(nums:List<Int>):Long{
        val n=nums.size;
        val squareFree=BooleanArray(n+1){
            true
        };
        var factor=2;
        while(factor*factor<=n){
            val square=factor*factor;
            var multiple=square;
            while(multiple<=n){
                squareFree[multiple]=false;
                multiple+=square
            };
            factor++
        };
        var answer=0L;
        for(base in 1..n){
            if(!squareFree[base])continue;
            var sum=0L;
            var multiplier=1;
            while(base.toLong()*multiplier*multiplier<=n){
                sum+=nums[base*multiplier*multiplier-1];
                multiplier++
            };
            answer=maxOf(answer,sum)
        };
        return answer
    }
}
