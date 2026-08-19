class Solution {
    fun minOperations(nums:IntArray,queries:IntArray):List<Long>{
        nums.sort();
        val prefix=LongArray(nums.size+1);
        for(i in nums.indices)prefix[i+1]=prefix[i]+nums[i];
        val answer=mutableListOf<Long>();
        for(query in queries){
            var left=0;
            var right=nums.size;
            while(left<right){
                val middle=(left+right)/2;
                if(nums[middle]<query)left=middle+1 else right=middle
            };
            answer.add(query.toLong()*left-prefix[left]+prefix[nums.size]-prefix[left]-query.toLong()*(nums.size-left))
        };
        return answer
    }
}
