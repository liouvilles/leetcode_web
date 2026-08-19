class Solution {
    fun mostFrequentIDs(nums:IntArray,freq:IntArray):LongArray{
        val frequency=HashMap<Int,Long>();
        val heap=java.util.PriorityQueue<LongArray>{
            first,second->if(first[0]!=second[0])java.lang.Long.compare(second[0],first[0])else java.lang.Long.compare(second[1],first[1])
        };
        val answer=LongArray(nums.size);
        for(index in nums.indices){
            val updated=(frequency[nums[index]]?:0L)+freq[index];
            frequency[nums[index]]=updated;
            heap.add(longArrayOf(updated,nums[index].toLong()));
            while((frequency[heap.peek()[1].toInt()]?:0L)!=heap.peek()[0])heap.poll();
            answer[index]=heap.peek()[0]
        };
        return answer
    }
}
