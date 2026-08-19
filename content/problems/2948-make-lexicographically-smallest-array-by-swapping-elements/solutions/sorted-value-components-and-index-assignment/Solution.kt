class Solution {
    fun lexicographicallySmallestArray(nums:IntArray,limit:Int):IntArray{
        val n=nums.size;
        val order=nums.indices.sortedBy{
            nums[it]
        };
        val answer=IntArray(n);
        var left=0;
        while(left<n){
            var right=left+1;
            while(right<n&&nums[order[right]].toLong()-nums[order[right-1]]<=limit.toLong())right++;
            val positions=IntArray(right-left){
                order[left+it]
            };
            positions.sort();
            for(offset in positions.indices)answer[positions[offset]]=nums[order[left+offset]];
            left=right
        };
        return answer
    }
}
