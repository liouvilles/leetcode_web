class Solution {
    private class Node{
        val next=arrayOfNulls<Node>(2)
    };
    private fun insert(rootValue:Node,value:Int){
        var root=rootValue;
        for(bit in 30 downTo 0){
            val digit=value shr bit and 1;
            if(root.next[digit]==null)root.next[digit]=Node();
            root=root.next[digit]!!
        }
    };
    private fun query(rootValue:Node,value:Int):Int{
        var root=rootValue;
        var answer=0;
        for(bit in 30 downTo 0){
            val digit=value shr bit and 1;
            val wanted=digit xor 1;
            if(root.next[wanted]!=null){
                answer=answer or (1 shl bit);
                root=root.next[wanted]!!
            }else root=root.next[digit]!!
        };
        return answer
    };
    fun maximizeXor(nums:IntArray,queries:Array<IntArray>):IntArray{
        nums.sort();
        val order=queries.indices.sortedBy{
            queries[it][1]
        };
        val answer=IntArray(queries.size);
        val root=Node();
        var inserted=0;
        for(index in order){
            while(inserted<nums.size&&nums[inserted]<=queries[index][1])insert(root,nums[inserted++]);
            answer[index]=if(inserted==0)-1 else query(root,queries[index][0])
        };
        return answer
    }
}
