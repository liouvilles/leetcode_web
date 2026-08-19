class Solution {
    fun minJumps(arr:IntArray):Int{
        val indices=mutableMapOf<Int,MutableList<Int>>();
        for(i in arr.indices)indices.getOrPut(arr[i]){
            mutableListOf()
        }.add(i);
        val queue=java.util.ArrayDeque<IntArray>();
        val seen=BooleanArray(arr.size);
        queue.addLast(intArrayOf(0,0));
        seen[0]=true;
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            val index=state[0];
            if(index==arr.lastIndex)return state[1];
            val next=mutableListOf<Int>();
            if(index>0)next.add(index-1);
            if(index<arr.lastIndex)next.add(index+1);
            next.addAll(indices[arr[index]]?:emptyList());
            for(value in next)if(!seen[value]){
                seen[value]=true;
                queue.addLast(intArrayOf(value,state[1]+1))
            };
            indices.remove(arr[index])
        };
        return -1
    }
}
