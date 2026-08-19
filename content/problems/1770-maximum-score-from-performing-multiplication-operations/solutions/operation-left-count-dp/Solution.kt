class Solution {
    private lateinit var nums:IntArray;
    private lateinit var multipliers:IntArray;
    private lateinit var memo:Array<IntArray>;
    private fun dfs(step:Int,left:Int):Int{
        if(step==multipliers.size)return 0;
        if(memo[step][left]!=Int.MIN_VALUE)return memo[step][left];
        val right=nums.size-1-(step-left);
        memo[step][left]=maxOf(nums[left]*multipliers[step]+dfs(step+1,left+1),nums[right]*multipliers[step]+dfs(step+1,left));
        return memo[step][left]
    };
    fun maximumScore(nums:IntArray,multipliers:IntArray):Int{
        this.nums=nums;
        this.multipliers=multipliers;
        memo=Array(multipliers.size){
            IntArray(multipliers.size){
                Int.MIN_VALUE
            }
        };
        return dfs(0,0)
    }
}
