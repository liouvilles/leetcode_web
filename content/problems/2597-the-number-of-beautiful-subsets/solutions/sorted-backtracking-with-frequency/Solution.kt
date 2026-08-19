class Solution {
    fun beautifulSubsets(nums:IntArray,k:Int):Int{
        nums.sort();
        val frequency=HashMap<Int,Int>();
        fun dfs(index:Int):Int{
            if(index==nums.size)return 1;
            var ways=dfs(index+1);
            val value=nums[index];
            if(frequency.getOrDefault(value-k,0)==0){
                frequency[value]=frequency.getOrDefault(value,0)+1;
                ways+=dfs(index+1);
                frequency[value]=frequency[value]!!-1
            };
            return ways
        };
        return dfs(0)-1
    }
}
