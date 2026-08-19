class Solution {
    private lateinit var nums:IntArray;
    private lateinit var powers:IntArray;
    private lateinit var memo:IntArray;
    private var slots=0;
    private fun dfs(index:Int,mask:Int):Int{
        if(index==nums.size)return 0;
        if(memo[mask]>=0)return memo[mask];
        var best=0;
        for(slot in 0 until slots)if(mask/powers[slot]%3<2)best=maxOf(best,(nums[index] and (slot+1))+dfs(index+1,mask+powers[slot]));
        memo[mask]=best;
        return best
    };
    fun maximumANDSum(nums:IntArray,numSlots:Int):Int{
        this.nums=nums;
        slots=numSlots;
        powers=IntArray(slots);
        var states=1;
        for(i in 0 until slots){
            powers[i]=states;
            states*=3
        };
        memo=IntArray(states){
            -1
        };
        return dfs(0,0)
    }
}
