class Solution {
    fun maxScore(nums1:IntArray,nums2:IntArray,k:Int):Long{
        val order=nums1.indices.sortedByDescending{
            nums2[it]
        };
        val heap=java.util.PriorityQueue<Int>();
        var sum=0L;
        var answer=0L;
        for(index in order){
            heap.offer(nums1[index]);
            sum+=nums1[index];
            if(heap.size>k)sum-=heap.poll();
            if(heap.size==k)answer=maxOf(answer,sum*nums2[index])
        };
        return answer
    }
}
