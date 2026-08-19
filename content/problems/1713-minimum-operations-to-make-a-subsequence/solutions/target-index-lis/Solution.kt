class Solution {
    fun minOperations(target:IntArray,arr:IntArray):Int{
        val index=target.indices.associateBy{
            target[it]
        };
        val tails=mutableListOf<Int>();
        for(value in arr){
            val position=index[value]?:continue;
            var left=0;
            var right=tails.size;
            while(left<right){
                val mid=(left+right) ushr 1;
                if(tails[mid]<position)left=mid+1 else right=mid
            };
            if(left==tails.size)tails.add(position) else tails[left]=position
        };
        return target.size-tails.size
    }
}
