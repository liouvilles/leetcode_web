class Solution {
    private class Fenwick(n:Int){
        private val tree=IntArray(n+1)
        fun add(start:Int){var index=start;while(index<tree.size){tree[index]++;index+=index and -index}}
        fun query(start:Int):Int{var index=start;var result=0;while(index>0){result+=tree[index];index-=index and -index};return result}
    }
    fun resultArray(nums:IntArray):IntArray{
        val sorted=nums.sortedArray()
        val first=ArrayList<Int>()
        val second=ArrayList<Int>()
        val firstTree=Fenwick(nums.size)
        val secondTree=Fenwick(nums.size)
        first.add(nums[0]);second.add(nums[1])
        firstTree.add(sorted.binarySearch(nums[0])+1)
        secondTree.add(sorted.binarySearch(nums[1])+1)
        for(index in 2 until nums.size){
            val rank=sorted.binarySearch(nums[index])+1
            val firstGreater=first.size-firstTree.query(rank)
            val secondGreater=second.size-secondTree.query(rank)
            if(firstGreater>secondGreater||firstGreater==secondGreater&&first.size<=second.size){
                first.add(nums[index]);firstTree.add(rank)
            }else{
                second.add(nums[index]);secondTree.add(rank)
            }
        }
        val answer=IntArray(nums.size)
        var write=0
        for(value in first)answer[write++]=value
        for(value in second)answer[write++]=value
        return answer
    }
}
