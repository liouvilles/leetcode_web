class Solution {
    fun maxBalancedSubsequenceSum(nums:IntArray):Long{
        val n=nums.size;
        val keys=LongArray(n){
            nums[it].toLong()-it
        };
        val sorted=keys.sorted().distinct();
        val tree=LongArray(sorted.size+1);
        var answer=Long.MIN_VALUE;
        for(i in nums.indices){
            val rank=sorted.binarySearch(keys[i])+1;
            var best=0L;
            var x=rank;
            while(x>0){
                best=maxOf(best,tree[x]);
                x-=x and -x
            };
            val current=nums[i]+best;
            answer=maxOf(answer,current);
            x=rank;
            while(x<tree.size){
                tree[x]=maxOf(tree[x],current);
                x+=x and -x
            }
        };
        return answer
    }
}
