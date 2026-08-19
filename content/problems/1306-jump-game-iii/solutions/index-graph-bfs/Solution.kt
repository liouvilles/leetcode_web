class Solution {
    fun canReach(arr:IntArray,start:Int):Boolean{
        val queue=java.util.ArrayDeque<Int>();
        val seen=BooleanArray(arr.size);
        queue.addLast(start);
        seen[start]=true;
        while(queue.isNotEmpty()){
            val index=queue.removeFirst();
            if(arr[index]==0)return true;
            for(next in intArrayOf(index-arr[index],index+arr[index]))if(next in arr.indices&&!seen[next]){
                seen[next]=true;
                queue.addLast(next)
            }
        };
        return false
    }
}
